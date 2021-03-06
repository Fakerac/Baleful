package com.fakerac.baleful.armor;

import com.fakerac.baleful.Baleful;
import com.fakerac.baleful.init.ItemInit;
import com.fakerac.baleful.util.RegistryHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum BalefulArmorMaterial implements IArmorMaterial {

    //Basically, the name in quotations determines what will be the path/name of the armor layer.
    ARDORIUM(Baleful.MOD_ID + ":ardorium", 43, new int[] { 3, 8, 6, 3}, 20,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F,
            () -> { return Ingredient.fromItems(ItemInit.ARDORIUM_INGOT.get()); }, 0.15F),

    MARQEYE(Baleful.MOD_ID + ":marqeye", 43, new int[] { 1, 2, 3, 1}, 15,
    SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F,
            () -> { return Ingredient.fromItems(ItemInit.ARDORIUM_INGOT.get()); }, 0.0F),

    SEAOFPIXELS(Baleful.MOD_ID + ":sop", 43, new int[] { 1, 2, 3, 1}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F,
            () -> { return Ingredient.fromItems(ItemInit.ARDORIUM_INGOT.get()); }, 0.0F),

    FAKERAC(Baleful.MOD_ID + ":fakerac", 43, new int[] { 1, 2, 3, 1}, 15,
    SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F,
            () -> { return Ingredient.fromItems(ItemInit.ARDORIUM_INGOT.get()); }, 0.0F),

    NYDARYX(Baleful.MOD_ID + ":nydaryx", 52, new int[] {3, 8, 6, 3}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 5.0F, () -> {return Ingredient.fromItems(ItemInit.ARDORIUM_INGOT.get())
    ; },0.25F);




    private static final int[] MAX_DAMAGE_ARRAY = new int[] {11, 16, 15, 13};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;
    private final float knockbackResistance;

    BalefulArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability,
                     SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial, float knockbackResistance){
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
        this.knockbackResistance = knockbackResistance;
    }



    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}

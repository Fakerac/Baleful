package com.fakerac.baleful.tools;

import com.fakerac.baleful.init.ItemInit;
import com.fakerac.baleful.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public enum BalefulItemTier implements IItemTier {

    JETSTREAM(5, 3021, 14.0F, 0.0F, 1, () -> {
        return Ingredient.EMPTY; }),

    ARDORIUM(5, 2561, 12.0F, 0.0F, 18, () -> {
        return Ingredient.fromItems(ItemInit.ARDORIUM_INGOT.get()); }),

    NYDARYX(6, 3542, 20.0F, 0.0F, 22, () -> {
        return Ingredient.fromItems(ItemInit.ARDORIUM_INGOT.get()); }),

    TIER1_WEAPON_TYPE(5, 3021, 12.0F, 0.0F, 20, () -> {
        return Ingredient.fromItems(ItemInit.TOURMALINE.get()); }),

    TIER2_WEAPON_TYPE_MALLET(6, 3021, 12.0F, 0.0F, 22, () -> {
        return Ingredient.fromItems(ItemInit.TOURMALINE.get()); });



    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    BalefulItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;

    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}

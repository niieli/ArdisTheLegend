package net.nieli.ardis.items;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ArdisSwordMaterial extends Item.Settings implements ToolMaterial {
    public static final ArdisSwordMaterial INSTANCE = new ArdisSwordMaterial();

    @Override
    public int getDurability() {
        return 4000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0.5f;
    }

    @Override
    public float getAttackDamage() {
        return 15.0f;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 50;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}

package net.nieli.ardis.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.nieli.ardis.entities.ArdisArrowEntity;

public class ArdisArrowItem extends ArrowItem {
    public ArdisArrowItem(Settings settings) {
        super(settings);
    }

    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new ArdisArrowEntity(world, shooter);
    }
}

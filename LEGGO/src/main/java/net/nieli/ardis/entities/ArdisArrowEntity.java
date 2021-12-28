package net.nieli.ardis.entities;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.world.World;

public class ArdisArrowEntity extends ArrowEntity {
    public ArdisArrowEntity(World entityType, LivingEntity world) {
        super(entityType, world);
    }
}
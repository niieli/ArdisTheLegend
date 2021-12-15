package net.fabricmc.ardis;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class RainbowZombie extends PathAwareEntity {

    public RainbowZombie(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
}

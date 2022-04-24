package net.nieli.ardis.entities.rainbowzombie;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import java.util.Random;

public class RainbowZombie extends ZombieEntity {

    public RainbowZombie(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder DUDEAttributes() {
        return ZombieEntity.createZombieAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 38.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.38D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.1D);
    }

    public static boolean canSpawn(EntityType<? extends HostileEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return pos.getY() < 0 && HostileEntity.canSpawnInDark(type, world, spawnReason, pos, random);
    }
}

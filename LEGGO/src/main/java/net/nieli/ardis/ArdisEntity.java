package net.nieli.ardis;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class ArdisEntity extends HostileEntity implements IAnimatable {
    public ArdisEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder ArdisAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 38.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.38D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 30.1D);
    }
    private final AnimationFactory factory = new AnimationFactory(this);

    @SuppressWarnings("unused")
    public static boolean canSpawn(EntityType<RainbowZombie> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return validSpawnBiomes(world, pos);
    }

    private static boolean validSpawnBiomes(WorldAccess world, BlockPos pos) {
        Optional<RegistryKey<Biome>> optional = world.getBiomeKey(pos);
        return (Objects.equals(optional, Optional.of(BiomeKeys.PLAINS)) ||
                Objects.equals(optional, Optional.of(BiomeKeys.BIRCH_FOREST)) ||
                Objects.equals(optional, Optional.of(BiomeKeys.FOREST)) ||
                Objects.equals(optional, Optional.of(BiomeKeys.FLOWER_FOREST)) ||
                Objects.equals(optional, Optional.of(BiomeKeys.SUNFLOWER_PLAINS)) ||
                (world.getBlockState(pos.down()).isOf(Blocks.GRASS) ||
                        world.getBlockState(pos.down()).isOf(Blocks.STONE) ||
                        world.getBlockState(pos.down()).isOf(Blocks.SAND)));
    }

    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}


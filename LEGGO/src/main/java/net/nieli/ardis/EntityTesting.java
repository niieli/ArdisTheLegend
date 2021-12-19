package net.nieli.ardis;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;

public class EntityTesting implements ModInitializer {

    /*
     * Registers our Zombie Entity under the ID "ardis-the-legend:zombie".
     *
     * The entity is registered under the SpawnGroup#CREATURE category, which is what most animals and passive/neutral mobs use.
     * It has a hitbox size of .75x.75, or 12 "pixels" wide (3/4ths of a block).
     */
    public static final EntityType<ArdisEntity> ARDISTEST = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("ardis-the-legend", "ardistest"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ArdisEntity::new).dimensions(EntityDimensions.fixed(0.5f, 1.2f)).build());
    static {
        SpawnRestrictionAccessor.callRegister(ARDISTEST, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ((type, world, spawnReason, pos, random) -> true));
    }
    public static final EntityType<RainbowZombie> RAINBOWZOMBIE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("ardis-the-legend", "rainbowzombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RainbowZombie::new).dimensions(EntityDimensions.fixed(0.75f, 2.05f)).build()
    );
    static {
        SpawnRestrictionAccessor.callRegister(RAINBOWZOMBIE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ((type, world, spawnReason, pos, random) -> true));
    }
    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(RAINBOWZOMBIE, RainbowZombie.DUDEAttributes());
        FabricDefaultAttributeRegistry.register(ARDISTEST, ArdisEntity.ArdisAttributes());
    }
}

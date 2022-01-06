package net.nieli.ardis.registry;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.nieli.ardis.ArdisTheLegendMod;
import net.nieli.ardis.entities.ArdisArrowEntity;
import net.nieli.ardis.entities.ArdisArrowRenderer;
import net.nieli.ardis.entities.rainbowzombie.RainbowZombie;
import net.nieli.ardis.entities.ardistest.ArdisEntity;
import software.bernie.example.registry.EntityRegistryBuilder;
import software.bernie.geckolib3.GeckoLib;

public class EntityRegistry implements ModInitializer {

    /*
     * Registers our Zombie Entity under the ID "ardis-the-legend:zombie".
     *
     * The entity is registered under the SpawnGroup#CREATURE category, which is what most animals and passive/neutral mobs use.
     * It has a hitbox size of .75x.75, or 12 "pixels" wide (3/4ths of a block).
     */
    public static final EntityType<ArdisArrowEntity> ARDISARROW;
    static {
        ARDISARROW = Registry.register(Registry.ENTITY_TYPE,
                new Identifier(ArdisTheLegendMod.MODID, "ardis_arrow"),
                FabricEntityTypeBuilder.<ArdisArrowEntity>create(SpawnGroup.MISC, ArdisArrowEntity::new)
                        .trackRangeBlocks(60).trackedUpdateRate(5).forceTrackedVelocityUpdates(true).build());
    }
    public static final EntityType<ArdisEntity> ARDISTEST = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("ardis-the-legend", "ardistest"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ArdisEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.8f)).build());
    static {
        SpawnRestrictionAccessor.callRegister(ARDISTEST, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ((type, world, spawnReason, pos, random) -> true));
    }
    public static final EntityType<RainbowZombie> RAINBOWZOMBIE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("ardis-the-legend", "rainbowzombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, RainbowZombie::new).dimensions(EntityDimensions.fixed(0.75f, 2.05f)).build()
    );

    static {
        SpawnRestrictionAccessor.callRegister(RAINBOWZOMBIE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ((type, world, spawnReason, pos, random) -> true));
    }
    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(RAINBOWZOMBIE, RainbowZombie.DUDEAttributes());
        FabricDefaultAttributeRegistry.register(ARDISTEST, ArdisEntity.createHostileAttributes());
    }
}

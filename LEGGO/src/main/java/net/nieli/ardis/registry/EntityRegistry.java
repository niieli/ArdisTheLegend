package net.nieli.ardis.registry;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.nieli.ardis.ArdisTheLegendMod;
import net.nieli.ardis.entities.ArdisArrowEntity;
import net.nieli.ardis.entities.ardistestv0.ArdisEntityV0;
import net.nieli.ardis.entities.rainbowzombie.RainbowZombie;
import net.nieli.ardis.entities.ardistest.ArdisEntity;

public class EntityRegistry implements ModInitializer {

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

    public static final EntityType<ArdisEntityV0> ARDISV0 = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ArdisTheLegendMod.MODID, "ardisv0"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ArdisEntityV0::new).dimensions(EntityDimensions.fixed(0.5f, 1.2f)).build());
    static {
        SpawnRestrictionAccessor.callRegister(ARDISV0, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ((type, world, spawnReason, pos, random) -> true));
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
        FabricDefaultAttributeRegistry.register(ARDISV0,ArdisEntityV0.createHostileAttributes());
    }
}

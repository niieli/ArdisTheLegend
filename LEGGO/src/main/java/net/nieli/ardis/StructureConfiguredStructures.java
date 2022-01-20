package net.nieli.ardis;

import net.minecraft.structure.PlainsVillageData;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import net.nieli.ardis.registry.ArdisStructures;

public class StructureConfiguredStructures {

    public static ConfiguredStructureFeature<?,?> CONFIGURED_ARDIS_HOUSE = ArdisStructures.ARDIS_HOUSE
            .configure(new StructurePoolFeatureConfig(() -> PlainsVillageData.STRUCTURE_POOLS, 0));

    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new Identifier(ArdisTheLegendMod.MODID, "configured_ardis_house"), CONFIGURED_ARDIS_HOUSE);
    }
}

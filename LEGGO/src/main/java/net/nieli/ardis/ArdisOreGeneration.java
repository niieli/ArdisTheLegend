package net.nieli.ardis;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;

import static net.nieli.ardis.ArdisTheLegendMod.ARDISINIUS_ORE;

public class ArdisOreGeneration implements ModInitializer {
    private static ConfiguredFeature<?, ?> ARDISINIUS_ORE_PLACE = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ARDISINIUS_ORE.getDefaultState(),
                    9)); // vein size

    public static PlacedFeature ARDISINIUS_ORE_PLACEE = ARDISINIUS_ORE_PLACE.withPlacement(
            CountPlacementModifier.of(20), // number of veins per chunk
            SquarePlacementModifier.of(), // spreading horizontally
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))); // height

    @Override
    public void onInitialize() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("ardis-the-legend", "ardisinius_ore"), ARDISINIUS_ORE_PLACE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("ardis-the-legend", "ardisinius_ore"),
                ARDISINIUS_ORE_PLACEE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("ardis-the-legend", "ardisinius_ore")));
    }
}

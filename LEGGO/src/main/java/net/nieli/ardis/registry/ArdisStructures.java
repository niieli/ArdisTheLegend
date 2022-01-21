package net.nieli.ardis.registry;

import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import net.nieli.ardis.ArdisTheLegendMod;
import net.nieli.ardis.structures.ArdisHouse;
import net.nieli.ardis.structures.ArdisHouseB;

public class ArdisStructures {

    public static StructureFeature<StructurePoolFeatureConfig> ARDIS_HOUSE = new ArdisHouse(StructurePoolFeatureConfig.CODEC);
    public static StructureFeature<StructurePoolFeatureConfig> ARDIS_HOUSEB = new ArdisHouseB(StructurePoolFeatureConfig.CODEC);

    public static void setupAndRegisterStructureFeatures(){
        FabricStructureBuilder.create(new Identifier(ArdisTheLegendMod.MODID,"ardis_house"), ARDIS_HOUSE)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(new StructureConfig(
                        1370,
                        1320,
                        234563263))
                .adjustsSurface()
                .register();

        FabricStructureBuilder.create(new Identifier(ArdisTheLegendMod.MODID,"ardis_houseb"), ARDIS_HOUSEB)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(new StructureConfig(
                        1640,
                        1570,
                        2130941755))
                .adjustsSurface()
                .register();
    }
}

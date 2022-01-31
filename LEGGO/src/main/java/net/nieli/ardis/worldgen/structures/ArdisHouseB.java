package net.nieli.ardis.worldgen.structures;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.PostPlacementProcessor;
import net.minecraft.structure.StructureGeneratorFactory;
import net.minecraft.structure.StructurePiecesGenerator;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import net.nieli.ardis.ArdisTheLegendMod;
import org.apache.logging.log4j.Level;

import java.util.Optional;

public class ArdisHouseB extends StructureFeature<StructurePoolFeatureConfig> {
    public ArdisHouseB(Codec<StructurePoolFeatureConfig> codec){
        super(codec, ArdisHouseB::createPiecesGenerator, PostPlacementProcessor.EMPTY);
    }

    public static final Pool<SpawnSettings.SpawnEntry> STRUCTURE_MONSTERS = Pool.of(
            new SpawnSettings.SpawnEntry(EntityType.ILLUSIONER, 100, 4, 9),
            new SpawnSettings.SpawnEntry(EntityType.VINDICATOR, 100, 4, 9)
    );

    public static final Pool<SpawnSettings.SpawnEntry> STRUCTURE_CREATURES = Pool.of(
            new SpawnSettings.SpawnEntry(EntityType.SHEEP, 30, 10, 15),
            new SpawnSettings.SpawnEntry(EntityType.RABBIT, 100, 1, 2)
    );

    public static boolean isFeatureChunk(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context){
        BlockPos spawnXZPosition = context.chunkPos().getCenterAtY(0);

        int landHeight = context.chunkGenerator().getHeightInGround(spawnXZPosition.getX(), spawnXZPosition.getZ(), Heightmap.Type.WORLD_SURFACE_WG, context.world());

        VerticalBlockSample columnOfBlocks = context.chunkGenerator().getColumnSample(spawnXZPosition.getX(), spawnXZPosition.getZ(), context.world());

        BlockState topBlock = columnOfBlocks.getState(landHeight);

        return topBlock.getFluidState().isEmpty(); //landHeight>100
    }

    public static Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> createPiecesGenerator(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context){

        if(!ArdisHouseB.isFeatureChunk(context)) {
            return Optional.empty();
        }
        StructurePoolFeatureConfig newConfig = new StructurePoolFeatureConfig(
                () -> context.registryManager().get(Registry.STRUCTURE_POOL_KEY)
                        .get(new Identifier(ArdisTheLegendMod.MODID, "ardis_houseb/ardishouseb")),
                10
        );

        StructureGeneratorFactory.Context<StructurePoolFeatureConfig> newContext = new StructureGeneratorFactory.Context<>(
                context.chunkGenerator(),
                context.biomeSource(),
                context.seed(),
                context.chunkPos(),
                newConfig,
                context.world(),
                context.validBiome(),
                context.structureManager(),
                context.registryManager()
        );

        BlockPos blockPos = context.chunkPos().getCenterAtY(0);

        Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> structurePiecesGenerator =
                StructurePoolBasedGenerator.generate(
                        newContext,
                        PoolStructurePiece::new,
                        blockPos,
                        false,
                        true
                ); // important! ^^
        if(structurePiecesGenerator.isPresent()){
            ArdisTheLegendMod.LOGGER.log(Level.DEBUG,"Ardis HouseB at " + blockPos);
        }
        return structurePiecesGenerator;
    }
}

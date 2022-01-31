package net.nieli.ardis.worldgen.structures;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.PostPlacementProcessor;
import net.minecraft.structure.StructureGeneratorFactory;
import net.minecraft.structure.StructurePiecesGenerator;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import net.nieli.ardis.ArdisTheLegendMod;
import org.apache.logging.log4j.Level;

import java.util.Optional;

public class ArdisHouse extends StructureFeature<StructurePoolFeatureConfig> {

    public ArdisHouse(Codec<StructurePoolFeatureConfig> codec){
        super(codec, ArdisHouse::createPiecesGenerator, PostPlacementProcessor.EMPTY);
    }

    public static boolean isFeatureChunk(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context){
        BlockPos spawnXZPosition = context.chunkPos().getCenterAtY(0);

        int landHeight = context.chunkGenerator().getHeightInGround(spawnXZPosition.getX(), spawnXZPosition.getZ(), Heightmap.Type.WORLD_SURFACE_WG, context.world());

        VerticalBlockSample columnOfBlocks = context.chunkGenerator().getColumnSample(spawnXZPosition.getX(), spawnXZPosition.getZ(), context.world());

        BlockState topBlock = columnOfBlocks.getState(landHeight);

        return topBlock.getFluidState().isEmpty(); //landHeight>100
    }

    public static Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> createPiecesGenerator(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context){

        if(!ArdisHouse.isFeatureChunk(context)) {
            return Optional.empty();
        }
        StructurePoolFeatureConfig newConfig = new StructurePoolFeatureConfig(
                () -> context.registryManager().get(Registry.STRUCTURE_POOL_KEY)
                        .get(new Identifier(ArdisTheLegendMod.MODID, "ardis_house/ardishouse")),
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
            ArdisTheLegendMod.LOGGER.log(Level.DEBUG,"Ardis House at " + blockPos);
        }
        return structurePiecesGenerator;
    }
}

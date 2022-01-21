package net.nieli.ardis;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.*;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.*;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.nieli.ardis.registry.ArdisStructures;
import net.nieli.ardis.registry.ItemsRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;


public class ArdisTheLegendMod implements ModInitializer {
	//TODO
	// Release 1.0.0
	// BOSS(Ardis)
	// ?Quest Book?
	// RainbowZombie Fähigkeit
	// Structures generieren
	// Rezept:
	// Ardis Food recipe/obtainable https://fabricmc.net/wiki/tutorial:recipes
	// Ardisnius Ore generation + richtige Texturen https://fabricmc.net/wiki/tutorial:blocks https://fabricmc.net/wiki/tutorial:ores
	// Ardisimo Wood https://fabricmc.net/wiki/tutorial:features https://fabricmc.net/wiki/tutorial:trees
	// Ardis Rüstung & Tools https://fabricmc.net/wiki/tutorial:armor https://fabricmc.net/wiki/tutorial:tools https://fabricmc.net/wiki/tutorial:shield
	public static final String MODID = "ardis-the-legend";

	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public static final ItemGroup ARDIS_THE_LEGEND = FabricItemGroupBuilder.build(
			new Identifier("ardis-the-legend", "general"),
			() -> new ItemStack(ItemsRegistry.ARDIS_BOW));
	//public static final DefaultParticleType GREEN_FLAME = FabricParticleTypes.simple();
	public static final DefaultParticleType RAINBOW_FLAME = FabricParticleTypes.simple();

	public static final StatusEffect SLEEPY = new SleepyTimeEffect();

	@Override
	public void onInitialize() {
		GeckoLib.initialize();
		ItemsRegistry.init();
		//Structures
		ArdisStructures.setupAndRegisterStructureFeatures();
		StructureConfiguredStructures.registerConfiguredStructures();
		addStructureSpawningToDimensionsAndBiomes();
		//HudRenderCallback.EVENT.register(new SpecialHUD()); //Hud overlay
		//particles
		//Registry.register(Registry.PARTICLE_TYPE, new Identifier(ArdisTheLegendMod.MODID, "green_flame"), GREEN_FLAME);
		Registry.register(Registry.PARTICLE_TYPE, new Identifier(ArdisTheLegendMod.MODID, "rainbow_flame"), RAINBOW_FLAME);
		//Status effects
		Registry.register(Registry.STATUS_EFFECT, new Identifier(ArdisTheLegendMod.MODID,"sleepy"), SLEEPY);
		LOGGER.info("Hello, this is Ardis!");
	}

	public static void addStructureSpawningToDimensionsAndBiomes() {
		BiomeModifications.addStructure(
				BiomeSelectors.categories(
						Biome.Category.DESERT,
						Biome.Category.EXTREME_HILLS,
						Biome.Category.FOREST,
						Biome.Category.ICY,
						Biome.Category.JUNGLE,
						Biome.Category.PLAINS,
						Biome.Category.SAVANNA,
						Biome.Category.TAIGA),
				RegistryKey.of(
						Registry.CONFIGURED_STRUCTURE_FEATURE_KEY,
						BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.getId(StructureConfiguredStructures.CONFIGURED_ARDIS_HOUSE))
		);
		BiomeModifications.addStructure(
				BiomeSelectors.categories(
						Biome.Category.DESERT,
						Biome.Category.EXTREME_HILLS,
						Biome.Category.FOREST,
						Biome.Category.ICY,
						Biome.Category.JUNGLE,
						Biome.Category.PLAINS,
						Biome.Category.SAVANNA,
						Biome.Category.TAIGA),
				RegistryKey.of(
						Registry.CONFIGURED_STRUCTURE_FEATURE_KEY,
						BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.getId(StructureConfiguredStructures.CONFIGURED_ARDIS_HOUSEB))
		);
	}
}
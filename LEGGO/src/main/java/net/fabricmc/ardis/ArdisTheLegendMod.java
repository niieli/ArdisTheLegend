package net.fabricmc.ardis;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.*;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static net.fabricmc.ardis.ArdisTheLegendMod.ArdisFood.RAINBOW_ZOMBIE_SPAWN_EGG;

public class ArdisTheLegendMod implements ModInitializer {
	//TODO bis Samstag
	// Rezept:
	// Ardis Food recipe/obtainable https://fabricmc.net/wiki/tutorial:recipes
	// Ardisnius Ore generation + richtige Texturen https://fabricmc.net/wiki/tutorial:blocks https://fabricmc.net/wiki/tutorial:ores
	// Ardisimo Wood https://fabricmc.net/wiki/tutorial:features https://fabricmc.net/wiki/tutorial:trees
	// Ardis Rüstung & Tools https://fabricmc.net/wiki/tutorial:armor https://fabricmc.net/wiki/tutorial:tools https://fabricmc.net/wiki/tutorial:shield
	//This logger is used to write text to the console and the log file.
	//It is considered best practice to use your mod id as the logger's name.
	//That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MODID = "ardis-the-legend";
	public static final String ZOMBIE_NAME = "rainbowzombie";

	public static final Logger LOGGER = LogManager.getLogger("ardis-the-legend");

	public static final ItemGroup ARDIS_THE_LEGEND = FabricItemGroupBuilder.build(
			new Identifier("ardis-the-legend", "general"),
			() -> new ItemStack(ArdisTheLegendMod.ARDIS_FOOD));

	// a block
	public static final ArdisiniusOre ARDISINIUS_ORE = new ArdisiniusOre(FabricBlockSettings.of(Material.STONE)
			.hardness(2.7f)
			.resistance(8.0f)
			.requiresTool());

	// an instance of our new item
	public static final ArdisFood ARDIS_FOOD = new ArdisFood(new FabricItemSettings()
			.group(ArdisTheLegendMod.ARDIS_THE_LEGEND)
			.maxCount(8)
			.rarity(Rarity.EPIC)
			.fireproof()
			.food(FoodComponents.ENCHANTED_GOLDEN_APPLE));
	public static class ArdisFood extends Item {

		public ArdisFood(Settings settings) {
			super(settings);
		}
		@Override
		public void appendTooltip(ItemStack itemStack, World world, List<net.minecraft.text.Text> tooltip, TooltipContext tooltipContext) {

			// default white text
			//tooltip.add( new TranslatableText("item.tutorial.fabric_item.tooltip") );

			//formatted GOLD text
			tooltip.add( new TranslatableText("item.ardis-the-legend.ardis_food.tooltip_1").formatted(Formatting.GOLD) );
			tooltip.add( new TranslatableText("item.ardis-the-legend.ardis_food.tooltip_2").formatted(Formatting.GOLD) );
		}
		public static final Item RAINBOW_ZOMBIE_SPAWN_EGG = new SpawnEggItem(EntityTesting.RAINBOWZOMBIE, 15546167, 15435290, new FabricItemSettings()
				.group(ArdisTheLegendMod.ARDIS_THE_LEGEND));

	}
	public static class ArdisiniusOre extends Block {
		public ArdisiniusOre(Settings settings) {
			super(settings);
		}


	}


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_food"), ARDIS_FOOD);
		Registry.register(Registry.BLOCK, new Identifier("ardis-the-legend", "ardisinius_ore"), ARDISINIUS_ORE);
		Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardisinius_ore"), new BlockItem(ARDISINIUS_ORE, new FabricItemSettings()
				.group(ArdisTheLegendMod.ARDIS_THE_LEGEND)));
		Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "rainbow_zombie_spawn_egg"), RAINBOW_ZOMBIE_SPAWN_EGG);

		LOGGER.info("Hello, this is Ardis!");
	}
}

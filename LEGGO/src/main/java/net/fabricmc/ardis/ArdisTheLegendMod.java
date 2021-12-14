package net.fabricmc.ardis;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
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

public class ArdisTheLegendMod implements ModInitializer {
	//TODO
	// Ardisnius Ore
	// Ardisimo Wood
	// Ardis Rüstung & Tools
	//This logger is used to write text to the console and the log file.
	//It is considered best practice to use your mod id as the logger's name.
	//That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("ardis-the-legend");

	public static final ItemGroup ARDIS_THE_LEGEND = FabricItemGroupBuilder.build(
			new Identifier("ardis-the-legend", "general"),
			() -> new ItemStack(ArdisTheLegendMod.ARDIS_FOOD));

	//public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
	//				new Identifier("ardis-the-legend", "other")) //TESTZWECKE, falls noch mehr kommt.
	//		.icon(() -> new ItemStack(Items.BOWL))
	//		.build();
	// ...

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
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_food"), ARDIS_FOOD);
		LOGGER.info("Hello, this is Ardis!");
	}
}

package net.nieli.ardis;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.nieli.ardis.registry.BlockRegistry;
import net.nieli.ardis.registry.ItemRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;


public class ArdisTheLegendMod implements ModInitializer {
	//TODO bis 28.12
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
			() -> new ItemStack(ItemRegistry.ARDIS_BOW));
	@Override
	public void onInitialize() {
		GeckoLib.initialize();
		ItemRegistry.init();
		BlockRegistry.init();
		LOGGER.info("Hello, this is Ardis!");
	}
}

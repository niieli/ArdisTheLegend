package net.nieli.ardis.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nieli.ardis.ArdisTheLegendMod;
import net.nieli.ardis.blocks.ArdisiniusOre;

public class BlockRegistry {
    public static final ArdisiniusOre ARDISINIUS_ORE = new ArdisiniusOre(FabricBlockSettings.of(Material.STONE).hardness(2.7f).resistance(8.0f).requiresTool());

    public static void init(){
        Registry.register(Registry.BLOCK, new Identifier("ardis-the-legend", "ardisinius_ore"), ARDISINIUS_ORE);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardisinius_ore"), new BlockItem(ARDISINIUS_ORE, new FabricItemSettings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND)));

    }
}

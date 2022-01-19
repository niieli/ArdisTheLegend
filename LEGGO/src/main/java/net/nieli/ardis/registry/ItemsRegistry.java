package net.nieli.ardis.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.nieli.ardis.ArdisTheLegendMod;
import net.nieli.ardis.blocks.ArdisiniusOre;
import net.nieli.ardis.items.*;

public class ItemsRegistry {
    //items
    public static final Item RAINBOW_ZOMBIE_SPAWN_EGG = new SpawnEggItem(EntityRegistry.RAINBOWZOMBIE, 15546167, 15435290, new FabricItemSettings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND));
    public static final RainbowDust RAINBOW_DUST = new RainbowDust(new FabricItemSettings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND).rarity(Rarity.RARE).fireproof());
    public static final ArdisFood ARDIS_FOOD = new ArdisFood(new FabricItemSettings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND).maxCount(8).rarity(Rarity.EPIC).fireproof().food(FoodComponents.ENCHANTED_GOLDEN_APPLE));
    public static final ArdisArrowItem ARDIS_ARROW_ITEM = new ArdisArrowItem(new Item.Settings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND));
    public static final ArdisBow ARDIS_BOW = new ArdisBow(new Item.Settings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND).rarity(Rarity.EPIC));
    public static final ArmorMaterial ARDIS_MATERIAL = new ArdisArmorMaterial();
    public static final Item ARDIS_HELMET = new ArmorItem(ARDIS_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND));
    public static final Item ARDIS_CHESTPLATE = new ArmorItem(ARDIS_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND));
    public static final Item ARDIS_LEGGINGS = new ArmorItem(ARDIS_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND));
    public static final Item ARDIS_BOOTS = new ArmorItem(ARDIS_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND));
    public static final ArdisSword ARDIS_SWORD = new ArdisSword(ArdisSwordMaterial.INSTANCE, 10, -2.7F, new Item.Settings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND).rarity(Rarity.EPIC).fireproof());

    //blocks
    public static final ArdisiniusOre ARDISINIUS_ORE = new ArdisiniusOre(FabricBlockSettings.of(Material.STONE).hardness(2.7f).resistance(8.0f).requiresTool());

    public static void init(){
        //items
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "rainbow_zombie_spawn_egg"), RAINBOW_ZOMBIE_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "rainbow_dust"), RAINBOW_DUST);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend","ardis_food"),ARDIS_FOOD);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_arrow"), ARDIS_ARROW_ITEM);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_bow"), ARDIS_BOW);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_sword"), ARDIS_SWORD);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_helmet"), ARDIS_HELMET);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_chestplate"), ARDIS_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_leggings"), ARDIS_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_boots"), ARDIS_BOOTS);

        //blocks
        Registry.register(Registry.BLOCK, new Identifier("ardis-the-legend", "ardisinius_ore"), ARDISINIUS_ORE);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardisinius_ore"), new BlockItem(ARDISINIUS_ORE, new FabricItemSettings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND)));
    }
}

package net.nieli.ardis.registry;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.nieli.ardis.ArdisTheLegendMod;
import net.nieli.ardis.items.*;

public class ItemRegistry {
    public static final ArdisArrowItem ARDIS_ARROW_ITEM = new ArdisArrowItem(new Item.Settings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND));
    public static final ArdisBow ARDIS_BOW = new ArdisBow(new Item.Settings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND).rarity(Rarity.EPIC));
    public static final ArmorMaterial ARDIS_MATERIAL = new ArdisArmorMaterial();
    public static final Item ARDIS_HELMET = new ArmorItem(ARDIS_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND));
    public static final Item ARDIS_CHESTPLATE = new ArmorItem(ARDIS_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND));
    public static final Item ARDIS_LEGGINGS = new ArmorItem(ARDIS_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND));
    public static final Item ARDIS_BOOTS = new ArmorItem(ARDIS_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND));
    public static final ArdisSword ARDIS_SWORD = new ArdisSword(ArdisSwordMaterial.INSTANCE, 10, -2.7F, new Item.Settings().group(ArdisTheLegendMod.ARDIS_THE_LEGEND).rarity(Rarity.EPIC).fireproof());

    public static void init(){
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_arrow"), ARDIS_ARROW_ITEM);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_bow"), ARDIS_BOW);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_sword"), ARDIS_SWORD);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_helmet"), ARDIS_HELMET);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_chestplate"), ARDIS_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_leggings"), ARDIS_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("ardis-the-legend", "ardis_boots"), ARDIS_BOOTS);

    }
}

package net.nieli.ardis.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import net.nieli.ardis.ArdisTheLegendMod;
import net.nieli.ardis.registry.EntityRegistry;

import java.util.List;

public class ArdisFood extends Item {

    public ArdisFood(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // default white text
        //tooltip.add( new TranslatableText("item.tutorial.fabric_item.tooltip") );

        //formatted GOLD text
        tooltip.add( new TranslatableText("item.ardis-the-legend.ardis_food.tooltip_1").formatted(Formatting.GOLD) );
        tooltip.add( new TranslatableText("item.ardis-the-legend.ardis_food.tooltip_2").formatted(Formatting.GOLD) );
    }
}

package net.nieli.ardis.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import static net.nieli.ardis.registry.ItemRegistry.ARDIS_BOW;

@Environment(EnvType.CLIENT)
public class ArdisTheLegendClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FabricModelPredicateProviderRegistry.register(ARDIS_BOW, new Identifier("pull"), (stack, world, entity, seed) ->  {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0F;
            }
        });

        FabricModelPredicateProviderRegistry.register(ARDIS_BOW, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F);
    }
}
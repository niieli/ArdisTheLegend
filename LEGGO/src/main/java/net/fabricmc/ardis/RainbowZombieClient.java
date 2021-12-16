package net.fabricmc.ardis;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RainbowZombieClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_ZOMBIE_LAYER = new EntityModelLayer(new Identifier("ardis-the-legend", "zombie"), "main");
    @Override
    public void onInitializeClient() {
        /*
         * Registers our Cube Entity's renderer, which provides a model and texture for the entity.
         *
         * Entity Renderers can also manipulate the model before it renders based on entity context (EndermanEntityRenderer#render).
         */
        // In 1.17, use EntityRendererRegistry.register (seen below) instead of EntityRendererRegistry.INSTANCE.register (seen above)
        EntityRendererRegistry.register(EntityTesting.RAINBOWZOMBIE, RainbowZombieRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_ZOMBIE_LAYER, RainbowZombieModel::getTexturedModelData);
    }
}

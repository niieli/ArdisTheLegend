package net.nieli.ardis.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.nieli.ardis.entities.rainbowzombie.RainbowZombieModel;
import net.nieli.ardis.entities.rainbowzombie.RainbowZombieRenderer;
import net.nieli.ardis.entities.ardistest.ArdisEntityRenderer;
import net.nieli.ardis.registry.EntityRegistry;

@Environment(EnvType.CLIENT)
public class EntityClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_ZOMBIE_LAYER = new EntityModelLayer(new Identifier("ardis-the-legend", "zombie"), "main");

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(EntityRegistry.RAINBOWZOMBIE, RainbowZombieRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.ARDISTEST, ArdisEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_ZOMBIE_LAYER, RainbowZombieModel::getTexturedModelData);
    }
}

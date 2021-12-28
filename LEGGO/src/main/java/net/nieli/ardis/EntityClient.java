package net.nieli.ardis;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.nieli.ardis.entities.ArdisArrowEntity;
import net.nieli.ardis.items.ArdisArrowItem;

import java.util.UUID;

@Environment(EnvType.CLIENT)
public class EntityClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_ZOMBIE_LAYER = new EntityModelLayer(new Identifier("ardis-the-legend", "zombie"), "main");

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(EntityTesting.RAINBOWZOMBIE, RainbowZombieRenderer::new);
        EntityRendererRegistry.register(EntityTesting.ARDISTEST, ArdisEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_ZOMBIE_LAYER, RainbowZombieModel::getTexturedModelData);
    }
}

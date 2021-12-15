package net.fabricmc.ardis;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */
public class RainbowZombieRenderer extends MobEntityRenderer<RainbowZombie, RainbowZombieModel> {

    public RainbowZombieRenderer(EntityRendererFactory.Context context) {
        super(context, new RainbowZombieModel(context.getPart(RainbowZombieClient.MODEL_ZOMBIE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(RainbowZombie entity) {
        return new Identifier("ardis-the-legend", "textures/entity/zombie/cube.png");
    }
}

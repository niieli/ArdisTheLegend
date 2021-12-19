package net.nieli.ardis;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.util.Identifier;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */
public class RainbowZombieRenderer extends MobEntityRenderer<RainbowZombie, ZombieEntityModel<RainbowZombie>> {

    public RainbowZombieRenderer(EntityRendererFactory.Context context) {
        super(context, new ZombieEntityModel<>(context.getPart(EntityModelLayers.ZOMBIE)), 0.5F);
    }

    @Override
    public Identifier getTexture(RainbowZombie rainbowZombie) {
        return new Identifier("ardis-the-legend", "textures/entity/zombie/rainbowzombie.png");
    }
}

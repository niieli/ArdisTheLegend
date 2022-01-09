package net.nieli.ardis.entities;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.nieli.ardis.ArdisTheLegendMod;

public class ArdisArrowRenderer extends ProjectileEntityRenderer<ArdisArrowEntity> {

    public ArdisArrowRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    protected int getBlockLight(ArdisArrowEntity entity, BlockPos pos) {
        return 15;
    }
    @Override
    public Identifier getTexture(ArdisArrowEntity entity) {
        return new Identifier(ArdisTheLegendMod.MODID,"textures/entity/projectiles/ardis_arrow.png");
    }
}

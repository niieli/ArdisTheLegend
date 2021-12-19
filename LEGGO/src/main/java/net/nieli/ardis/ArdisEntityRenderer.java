package net.nieli.ardis;

import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ArdisEntityRenderer extends GeoEntityRenderer<ArdisEntity> {
    public ArdisEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ArdisEntityModel());
        this.shadowRadius = 0.5f;
    }
}

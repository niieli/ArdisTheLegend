package net.nieli.ardis.entities.ardistest;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class ArdisEntityRenderer extends GeoEntityRenderer<ArdisEntity> {
    public ArdisEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ArdisEntityModel());
        this.shadowRadius = 0.3f;
    }
    @Override
    public RenderLayer getRenderType(ArdisEntity animatable, float partialTicks, MatrixStack stack,
                                     @Nullable VertexConsumerProvider renderTypeBuffer, @Nullable VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(this.getTextureLocation(animatable));
    }
}

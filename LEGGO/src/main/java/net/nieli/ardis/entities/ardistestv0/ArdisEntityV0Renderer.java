package net.nieli.ardis.entities.ardistestv0;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class ArdisEntityV0Renderer extends GeoEntityRenderer<ArdisEntityV0> {
    public ArdisEntityV0Renderer(EntityRendererFactory.Context context) {
        super(context, new ArdisEntityV0Model());
        this.shadowRadius = 0.3f;
    }
    @Override
    public RenderLayer getRenderType(ArdisEntityV0 animatable, float partialTicks, MatrixStack stack,
                                     @Nullable VertexConsumerProvider renderTypeBuffer, @Nullable VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(this.getTextureLocation(animatable));
    }
}

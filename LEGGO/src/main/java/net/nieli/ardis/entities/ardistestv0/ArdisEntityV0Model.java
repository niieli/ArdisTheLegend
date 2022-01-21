package net.nieli.ardis.entities.ardistestv0;

import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ArdisEntityV0Model extends AnimatedTickingGeoModel<ArdisEntityV0> {

    @Override
    public Identifier getModelLocation(ArdisEntityV0 object) {
        return new Identifier("ardis-the-legend", "geo/ardisentity.geo.json");
    }

    @Override
    public Identifier getTextureLocation(ArdisEntityV0 object) {
        return new Identifier("ardis-the-legend", "textures/entity/ardisv0/ardisv0.png");
    }

    @Override
    public Identifier getAnimationFileLocation(ArdisEntityV0 animatable) {
        return new Identifier("ardis-the-legend", "animations/ardisentity.animation.json");
    }

    @SuppressWarnings({ "unchecked", "unused"})
    @Override
    public void setLivingAnimations(ArdisEntityV0 entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        HostileEntity entityIn = (HostileEntity) entity;
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }
}

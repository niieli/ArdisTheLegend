package net.nieli.ardis.entities.ardistest;

import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ArdisEntityModel extends AnimatedTickingGeoModel<ArdisEntity> {

    @Override
    public Identifier getModelLocation(ArdisEntity object) {
        return new Identifier("ardis-the-legend", "geo/ardisentityv2.geo.json");
    }

    @Override
    public Identifier getTextureLocation(ArdisEntity object) {
        return new Identifier("ardis-the-legend", "textures/entity/ardis/ardistextures.png");
    }

    @Override
    public Identifier getAnimationFileLocation(ArdisEntity animatable) {
        return new Identifier("ardis-the-legend", "animations/ardisentityv2.animation.json");
    }

    @SuppressWarnings({ "unchecked", "unused"})
    @Override
    public void setLivingAnimations(ArdisEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        HostileEntity entityIn = (HostileEntity) entity;
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }
}

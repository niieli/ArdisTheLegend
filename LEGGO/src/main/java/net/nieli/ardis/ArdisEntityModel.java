package net.nieli.ardis;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArdisEntityModel extends AnimatedGeoModel<ArdisEntity> {
    @Override
    public Identifier getModelLocation(ArdisEntity object){
        return new Identifier("ardis-the-legend", "geo/ardisentitymodel.geo.json");
    }

    @Override
    public Identifier getTextureLocation(ArdisEntity object) {
        return new Identifier("ardis-the-legend", "textures/entity/zombie/ardisentity.png");
    }

    @Override
    public Identifier getAnimationFileLocation(ArdisEntity animatable) {
        return new Identifier("ardis-the-legend", "animations/ardisentity.animations.json");
    }
}

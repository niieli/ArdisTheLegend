package net.nieli.ardis.entities.ardistestv0;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.IAnimationTickable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class ArdisEntityV0 extends HostileEntity implements IAnimatable, IAnimationTickable {

    //public static DefaultAttributeContainer.Builder ArdisAttributes() {
    //return HostileEntity.createHostileAttributes()
    //.add(EntityAttributes.GENERIC_MAX_HEALTH, 38.0D)
    //.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.38D)
    //.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 30.1D);
    //}

    private AnimationFactory factory = new AnimationFactory(this);

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ardisentity.vibe", true));
        return PlayState.CONTINUE;
    }

    public ArdisEntityV0(EntityType<? extends HostileEntity> type, World worldIn) {
        super(type, worldIn);
        this.ignoreCameraFrustum = true;
    }

    @Override
    public void registerControllers(AnimationData data)
    {
        data.addAnimationController(new AnimationController<ArdisEntityV0>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory()
    {
        return this.factory;
    }

    @Override
    public int tickTimer() {
        return age;
    }
}

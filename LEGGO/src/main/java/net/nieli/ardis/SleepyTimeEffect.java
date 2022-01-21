package net.nieli.ardis;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

public class SleepyTimeEffect extends StatusEffect {
    public SleepyTimeEffect() {
        super(StatusEffectCategory.HARMFUL, 112150207);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier){
        return true;
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier){
        BlockPos blockPos = entity.getBlockPos();
        if(entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).sleep(blockPos);
        }
    }
}

package net.fabricmc.ardis.mixin;

import net.fabricmc.ardis.EntityTesting;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public abstract class ZombieModSpawnMixin {
    @Inject(at = @At("TAIL"), method = "addMonsters")
    private static void addRainbowZombie(SpawnSettings.Builder builder, int zombieWeight, int zombieVillagerWeight, int skeletonWeight, boolean drowned, CallbackInfo ci) {
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityTesting.RAINBOWZOMBIE, 50, 1, 3));
    }
}

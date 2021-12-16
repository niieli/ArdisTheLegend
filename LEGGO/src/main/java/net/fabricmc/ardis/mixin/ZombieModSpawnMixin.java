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
    @Inject(at = @At("TAIL"), method = "addFarmAnimals")
    private static void addZombieModSpawns(SpawnSettings.Builder builder, CallbackInfo info) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityTesting.RAINBOWZOMBIE, 100, 1, 3));
    }
    @Inject(at = @At("TAIL"), method = "addPlainsMobs")
    private static void addZombiePlainsSpawn(SpawnSettings.Builder builder, CallbackInfo info) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityTesting.RAINBOWZOMBIE, 100, 2, 5));
    }

    @Inject(at = @At("TAIL"), method = "addDesertMobs")
    private static void addZombieDesertSpawn(SpawnSettings.Builder builder, CallbackInfo info) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityTesting.RAINBOWZOMBIE, 100, 2, 5));
    }
}

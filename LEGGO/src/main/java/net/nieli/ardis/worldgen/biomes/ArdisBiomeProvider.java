package net.nieli.ardis.worldgen.biomes;

import com.mojang.datafixers.util.Pair;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import terrablender.api.BiomeProvider;
import terrablender.worldgen.TBClimate;

import java.util.function.Consumer;

public class ArdisBiomeProvider extends BiomeProvider {
    public ArdisBiomeProvider(Identifier name, int overworldWeight) {
        super(name, overworldWeight);
    }

    @Override
    public void addOverworldBiomes(Registry<Biome> registry, Consumer<Pair<TBClimate.ParameterPoint, RegistryKey<Biome>>> mapper)
    {

    }
}

package net.fabricmc.ardis;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityTesting implements ModInitializer {

    /*
     * Registers our Zombie Entity under the ID "ardis-the-legend:zombie".
     *
     * The entity is registered under the SpawnGroup#CREATURE category, which is what most animals and passive/neutral mobs use.
     * It has a hitbox size of .75x.75, or 12 "pixels" wide (3/4ths of a block).
     */
    public static final EntityType<RainbowZombie> RAINBOWZOMBIE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("ardis-the-legend", "rainbowzombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RainbowZombie::new).dimensions(EntityDimensions.fixed(0.75f, 2.05f)).build()
    );
    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(RAINBOWZOMBIE, RainbowZombie.DUDEAttributes());
    }
}

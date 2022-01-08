package net.nieli.ardis.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.particle.FireworksSparkParticle;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.nieli.ardis.ArdisTheLegendMod;

import static net.nieli.ardis.registry.ItemRegistry.ARDIS_BOW;

@Environment(EnvType.CLIENT)
public class ArdisTheLegendClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FabricModelPredicateProviderRegistry.register(ARDIS_BOW, new Identifier("pull"), (stack, world, entity, seed) ->  {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0F;
            }
        });

        FabricModelPredicateProviderRegistry.register(ARDIS_BOW, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F);
        /* Adds our particle textures to vanilla's Texture Atlas so it can be shown properly.
         * Modify the namespace and particle id accordingly.
         *
         * This is only used if you plan to add your own textures for the particle. Otherwise, remove  this.*/
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            //registry.register(new Identifier(ArdisTheLegendMod.MODID, "particle/green_flame"));
            registry.register(new Identifier(ArdisTheLegendMod.MODID, "particle/rainbow_flame"));
        }));

        /* Registers our particle client-side.
         * First argument is our particle's instance, created previously on ExampleMod.
         * Second argument is the particle's factory. The factory controls how the particle behaves.
         * In this example, we'll use FlameParticle's Factory.*/
        //ParticleFactoryRegistry.getInstance().register(ArdisTheLegendMod.GREEN_FLAME, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ArdisTheLegendMod.RAINBOW_FLAME, FlameParticle.Factory::new);
    }
}
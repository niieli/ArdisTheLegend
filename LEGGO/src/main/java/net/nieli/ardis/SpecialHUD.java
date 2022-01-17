package net.nieli.ardis;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SpecialHUD extends DrawableHelper implements HudRenderCallback {
    private static final Identifier IMAGE = new Identifier(ArdisTheLegendMod.MODID,"textures/hud/ardishello.png");
    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        RenderSystem.setShaderTexture(0, IMAGE);
        DrawableHelper.drawTexture(matrixStack,200,20,0,0,0,100,100,100,100);
    }
}

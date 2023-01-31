package dev.isxander.controlify.mixins;

import dev.isxander.controlify.Controlify;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/KeyboardHandler;setup(J)V", shift = At.Shift.AFTER))
    private void onInputInitialized(CallbackInfo ci) {
        Controlify.getInstance().onInitializeInput();
    }
}

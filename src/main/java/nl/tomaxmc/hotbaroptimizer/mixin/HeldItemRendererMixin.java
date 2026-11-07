package nl.tomaxmc.hotbaroptimizer.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Vanilla laat het item eerst naar beneden zakken en daarna het nieuwe item omhoog komen
 * zodra je van hotbar-slot wisselt. Deze mixin slaat die animatie over: na elke tick staat
 * het huidige item meteen volledig omhoog in beeld.
 */
@Mixin(HeldItemRenderer.class)
public abstract class HeldItemRendererMixin {

	@Shadow @Final private MinecraftClient client;

	@Shadow private ItemStack mainHand;
	@Shadow private ItemStack offHand;

	@Shadow private float equipProgressMainHand;
	@Shadow private float prevEquipProgressMainHand;
	@Shadow private float equipProgressOffHand;
	@Shadow private float prevEquipProgressOffHand;

	@Inject(method = "updateHeldItems", at = @At("TAIL"))
	private void tomaxmc$skipEquipAnimation(CallbackInfo ci) {
		ClientPlayerEntity player = this.client.player;
		if (player == null) {
			return;
		}

		this.mainHand = player.getMainHandStack();
		this.offHand = player.getOffHandStack();

		this.equipProgressMainHand = 1.0f;
		this.prevEquipProgressMainHand = 1.0f;
		this.equipProgressOffHand = 1.0f;
		this.prevEquipProgressOffHand = 1.0f;
	}
}

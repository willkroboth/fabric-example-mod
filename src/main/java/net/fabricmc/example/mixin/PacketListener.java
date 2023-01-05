package net.fabricmc.example.mixin;

import io.netty.channel.ChannelHandlerContext;
import net.fabricmc.example.ExampleMod;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class PacketListener {
    @Inject(at = @At("HEAD"), method = "channelRead0(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/Packet;)V")
    public void interceptPacket(ChannelHandlerContext channelHandlerContext, Packet<?> packet, CallbackInfo ci) {
        ExampleMod.LOGGER.info("Intercepted packet");
        ExampleMod.LOGGER.info(packet.getClass().toString());
        ExampleMod.LOGGER.info(packet.toString());
    }
}

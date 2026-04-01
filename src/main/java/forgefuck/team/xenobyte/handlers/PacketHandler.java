package forgefuck.team.xenobyte.handlers;

import forgefuck.team.xenobyte.api.Xeno;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;

public class PacketHandler {
    private static final String XENO_PACKET_HANDLER = "xeno_packet_handler";
    
    public PacketHandler(ModuleHandler handler, NetHandlerPlayClient clientHandler) {
        if (handler != null && clientHandler != null) {
            if (clientHandler.getNetworkManager().channel().pipeline().get(XENO_PACKET_HANDLER) != null) {
                clientHandler.getNetworkManager().channel().pipeline().remove(XENO_PACKET_HANDLER);
            }
            clientHandler.getNetworkManager().channel().pipeline().addBefore("packet_handler", XENO_PACKET_HANDLER, new ChannelDuplexHandler() {
                @Override public void channelRead(ChannelHandlerContext ctx, Object in) throws Exception {
                    if (handler.enabledModules().allMatch(m -> m.doReceivePacket((Packet) in))) {
                        super.channelRead(ctx, in);
                    }
                }
                @Override public void write(ChannelHandlerContext ctx, Object out, ChannelPromise pr) throws Exception {
                    if (handler.enabledModules().allMatch(m -> m.doSendPacket((Packet) out))) {
                        super.write(ctx, out, pr);
                    }
                }
                @Override public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
                    Xeno.logger.info("XenoPacketHandler registered: " + ctx.name());
                }
            });
        }
    }

}

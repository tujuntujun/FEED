package com.ruoyi.web.controller.transmessage;


import com.ruoyi.web.controller.server.TcpServerHandler;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MI on 2019/5/8.
 */
public class TransServerHandler extends ChannelInboundHandlerAdapter {
    private static Logger log = LogManager.getLogger(TcpServerHandler.class);
    private static List<Channel> channels = new ArrayList<>();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        String data = in.toString(CharsetUtil.UTF_8);
        System.out.println(data);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("exceptionCaught!cause:" + cause.toString());
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        Channel channel = ctx.channel();
        channels.add(channel);
        sendMessage(channel, "success!\n");
    }

    public static void sendMessage(String msg) {
        for (Channel channel : channels) {
            channel.writeAndFlush(msg);
        }
    }

    public static void sendMessage(Channel channel, String msg) {
        channel.writeAndFlush(msg);
    }
}
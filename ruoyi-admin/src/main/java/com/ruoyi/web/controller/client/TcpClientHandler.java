package com.ruoyi.web.controller.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author 张超 teavamc
 * @Description:TODO
 * @ClassName TcpClientHandler
 * @date 2019/5/2 13:22
 **/
public class TcpClientHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("client接收到服务器返回的消息:" + msg);
    }
}


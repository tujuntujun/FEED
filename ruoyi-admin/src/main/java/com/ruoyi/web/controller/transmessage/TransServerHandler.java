package com.ruoyi.web.controller.transmessage;


import com.ruoyi.service.domain.Pigstyinfo;
import com.ruoyi.service.mapper.PigstyinfoMapper;
import com.ruoyi.web.controller.server.TcpServerHandler;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.springframework.context.ApplicationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MI on 2019/5/8.
 */
public class TransServerHandler extends ChannelInboundHandlerAdapter {
    private static Logger log = LogManager.getLogger(TcpServerHandler.class);
    private static List<Channel> channels = new ArrayList<>();
    @Autowired
    private PigstyinfoMapper pigstyinfoMapper;

    private static ApplicationContext applicationContext;

    public TransServerHandler() {
        pigstyinfoMapper = applicationContext.getBean(PigstyinfoMapper.class);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        String data = in.toString(CharsetUtil.UTF_8);
        String message[] = data.split(";");
        Pigstyinfo pigstyinfo = new Pigstyinfo();
        pigstyinfo.setTemV(new Integer(message[0]));
        pigstyinfo.setRhV(new Integer(message[1]));
        pigstyinfo.setAgV(new Float(message[2]));
        pigstyinfo.setLightV(new Float(message[3]));
        pigstyinfo.setRecTime(new Date());
        try {
            pigstyinfoMapper.insertPigstyinfo(pigstyinfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        TransServerHandler.applicationContext = applicationContext;
    }

    public static void sendMessage(Channel channel, String msg) {
        channel.writeAndFlush(msg);
    }
}
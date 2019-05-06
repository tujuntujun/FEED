package com.ruoyi.web.controller.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author 张超 teavamc
 * @Description:TODO
 * @ClassName TcpServerHandler
 * @date 2019/5/2 15:05
 **/
public class TcpServerHandler extends SimpleChannelInboundHandler<Object> {

    private static Logger log = LogManager.getLogger(TcpServerHandler.class);

    private final String OPENFAN = "01";
    private final String CLOSEFAN = "02";
    private final String OPENFANONE = "03";
    private final String CLOSEFANTWO = "04";
    private final String OPENGUA = "05";
    private final String CLOSEGUA = "06";
    private final String OPENCHUANG = "07";
    private final String CLOSECHUANG = "08";
    private final String SUCCEED = "1";
    private final String FAILED = "0";

    /**
     * @Description 打印接收到的内容，并回传
     * @author 张超 teavamc
     * @date 2019/5/4
     * @Time 16:25
     * @return void
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        switch(msg.toString())
        {
            case OPENFAN:
                log.info("TCP Server收到开启风扇1的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                break;
            case CLOSEFAN:
                log.info("TCP Server收到关闭风扇1的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                break;
            case OPENFANONE:
                log.info("TCP Server收到开启风扇2的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                break;
            case CLOSEFANTWO:
                log.info("TCP Server收到关闭风扇2的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                break;
            case OPENGUA:
                log.info("TCP Server收到开启刮粪板的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                break;
            case CLOSEGUA:
                log.info("TCP Server收到关闭刮粪板的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                break;
            case OPENCHUANG:
                log.info("TCP Server收到开启窗帘的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                break;
            case CLOSECHUANG:
                log.info("TCP Server收到关闭窗帘的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                break;

            default:
                log.info("不明指令：" + msg);
                ctx.channel().writeAndFlush(FAILED);
        }

    }

    /**
     * @Description
     * @author 张超 teavamc
     * @date 2019/5/4
     * @Time 16:50
     * @return void
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("exceptionCaught!cause:" + cause.toString());
        ctx.close();
    }

}

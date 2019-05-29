package com.ruoyi.web.controller.server;

import com.ruoyi.web.controller.transmessage.TransServerHandler;
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
    private final String OPENFANTWO = "03";
    private final String CLOSEFANTWO = "04";
    private final String OPENGUA = "05";
    private final String CLOSEGUA = "06";
    private final String OPENCHUANG = "07";
    private final String CLOSECHUANG = "08";
    private final String OPENTOU = "09";
    private final String CLOSETOU = "10";
    private final String OPENSHUI = "11";
    private final String CLOSESHUI = "12";
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
                TransServerHandler.sendMessage("S"+msg+"E\n");
                break;
            case CLOSEFAN:
                log.info("TCP Server收到关闭风扇1的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                TransServerHandler.sendMessage("S"+msg+"E\n");
                break;
            case OPENFANTWO:
                log.info("TCP Server收到开启风扇2的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                TransServerHandler.sendMessage("S"+msg+"E\n");
                break;
            case CLOSEFANTWO:
                log.info("TCP Server收到关闭风扇2的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                TransServerHandler.sendMessage("S"+msg+"E\n");
                break;
            case OPENGUA:
                log.info("TCP Server收到开启刮粪板的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                TransServerHandler.sendMessage("S"+msg+"E\n");
                break;
            case CLOSEGUA:
                log.info("TCP Server收到复位刮粪板的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                TransServerHandler.sendMessage("S"+msg+"E\n");
                break;
            case OPENCHUANG:
                log.info("TCP Server收到开启窗帘的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                TransServerHandler.sendMessage("S"+msg+"E\n");
                break;
            case CLOSECHUANG:
                log.info("TCP Server收到关闭窗帘的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                TransServerHandler.sendMessage("S"+msg+"E\n");
                break;
            case OPENTOU:
            log.info("TCP Server收到开启投食的指令：" + msg);
            ctx.channel().writeAndFlush(SUCCEED);
            TransServerHandler.sendMessage("S"+msg+"E\n");
            break;
            case CLOSETOU:
                log.info("TCP Server收到关闭投食的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                TransServerHandler.sendMessage("S"+msg+"E\n");
                break;
            case OPENSHUI:
                log.info("TCP Server收到开启喂水的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                TransServerHandler.sendMessage("S"+msg+"E\n");
                break;
            case CLOSESHUI:
                log.info("TCP Server收到关闭喂水的指令：" + msg);
                ctx.channel().writeAndFlush(SUCCEED);
                TransServerHandler.sendMessage("S"+msg+"E\n");
                break;

            default:
                log.info("不明指令：" + msg);
                ctx.channel().writeAndFlush(FAILED);
                TransServerHandler.sendMessage("S"+msg+"E\n");
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

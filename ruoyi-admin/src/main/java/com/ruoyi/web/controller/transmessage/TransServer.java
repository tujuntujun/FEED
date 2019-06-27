package com.ruoyi.web.controller.transmessage;



import com.ruoyi.web.controller.server.TcpServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by MI on 2019/5/8.
 */
public class TransServer {


    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private Channel serverChannel;

    public TransServer() {
        this.bossGroup = new NioEventLoopGroup();
        this.workerGroup = new NioEventLoopGroup();
    }

    private void start(int port){
        try {
            //start server
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel> (){

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            socketChannel.pipeline().addLast(new TransServerHandler());
                            pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
                            pipeline.addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
                            pipeline.addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
                        }
                    });
            b.option(ChannelOption.SO_BACKLOG,128);
            b.childOption(ChannelOption.SO_KEEPALIVE, true);
            b.childOption(ChannelOption.TCP_NODELAY, true);
            b.childOption(ChannelOption.SO_REUSEADDR, true);
            ChannelFuture f = b.bind(port).sync();
            serverChannel = f.channel();

            System.out.println("Server start OK!");
        }catch (Exception ex){
            System.out.println("Server start error: " + ex.getMessage());
            stop();
        }
    }

    private void stop(){
        if (serverChannel != null) {
            serverChannel.close();
        }
        if (workerGroup != null) {
            workerGroup.shutdownGracefully();
        }
        if (bossGroup != null) {
            bossGroup.shutdownGracefully();
        }

        System.out.println("Server is shut down");
    }

    public void doStart(){
        int port = 1234;
        try {
            start(port);
        } catch (Exception e) {
            System.out.println("Server start error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new TransServer().doStart();
    }

    public void doStop() {
        stop();
    }

}


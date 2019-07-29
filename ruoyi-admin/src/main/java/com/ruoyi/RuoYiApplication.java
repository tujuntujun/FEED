package com.ruoyi;

import com.ruoyi.web.controller.server.TcpServer;
import com.ruoyi.web.controller.transmessage.TransServer;
import com.ruoyi.web.controller.transmessage.TransServerHandler;
import org.apache.catalina.core.ApplicationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.ruoyi.*.mapper")
public class RuoYiApplication implements CommandLineRunner {

    private static Logger log = LogManager.getLogger(RuoYiApplication.class);

    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication springApplication = new SpringApplication(RuoYiApplication.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        //解决WebSocket不能注入的问题
        TransServerHandler.setApplicationContext(configurableApplicationContext);

        System.out.println("(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ");

        try{
            TcpServer.run();
            System.out.print("tcp启动成功");
            // TcpServer.shutdown();
        }catch (Exception e ){
            System.out.println("tcp服务器启动失败");
        }

    }

    @Override
    public  void  run(String... String ){
        try {
            new TransServer().doStart();
            log.info("端口1234的服务器启动成功...");
        } catch (Exception e) {
            log.info("端口1234的服务器启动成功...");
            e.printStackTrace();
        }
    }
}
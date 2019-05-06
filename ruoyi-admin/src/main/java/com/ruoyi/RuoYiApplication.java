package com.ruoyi;

import com.ruoyi.web.controller.server.TcpServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.ruoyi.*.mapper")
public class RuoYiApplication implements CommandLineRunner {

    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
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

    }
}
package com.ruoyi;

import com.ruoyi.service.domain.Pigstyinfo;
import com.ruoyi.service.mapper.PigstyinfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuoYiApplicationTests {
    @Autowired
    private PigstyinfoMapper pigstyinfoMapper;

    @Test
    public void contextLoads() {
        String a = "-1;-1;62;102;";
        String[] message = a.split(";");
        Pigstyinfo pigstyinfo = new Pigstyinfo();
        pigstyinfo.setTemV(new Integer(message[0]));
        pigstyinfo.setRhV(new Integer(message[1]));
        pigstyinfo.setAgV(new Float(message[2]));
        pigstyinfo.setLightV(new Float(message[3]));
        pigstyinfo.setRecTime(new Date());
        System.out.println(pigstyinfo);
        try {
            pigstyinfoMapper.insertPigstyinfo(pigstyinfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

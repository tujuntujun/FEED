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
        Pigstyinfo pigstyinfo = new Pigstyinfo();
        pigstyinfo.setLogId(123);
        pigstyinfo.setDName("2333");
        pigstyinfo.setRecTime(new Date());
        pigstyinfo.setTemV(123);
        pigstyinfo.setRhV(123);
        pigstyinfo.setRhV(123);
        pigstyinfoMapper.insertPigstyinfo(pigstyinfo);
    }
}

package com.ruoyi;

import com.ruoyi.service.mapper.PigstyinfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuoYiApplicationTests {
    @Autowired
    private PigstyinfoMapper pigstyinfoMapper;

    @Test
    public void contextLoads() {
        System.out.println(pigstyinfoMapper.selectPigstyinfoById(1));
    }
}

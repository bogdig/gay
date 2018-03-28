package com.example.gay;

import com.example.gay.domain.Gay;
import com.example.gay.service.GayService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午7:02 2018/3/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GayServiceTest {

    @Autowired
    private GayService gayService;

    @Test
    public void findOneTest(){
        Gay gay = gayService.findOne(4);
        Assert.assertEquals(new Integer(15), gay.getAge());
    }
}

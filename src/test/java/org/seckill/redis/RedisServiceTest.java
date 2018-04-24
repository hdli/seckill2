package org.seckill.redis;

import org.junit.Test;
import org.seckill.BaseTest;
import org.seckill.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by hdli on 2018-3-5.
 */
public class RedisServiceTest extends BaseTest {
    @Autowired
    private RedisService redisService;

    @Test
    public void addValueTest(){
        System.out.println("---------------------开始-------------");
        redisService.addValue("a",new aaa().toString());
        System.out.println("--------------------结束--------------");
    }
}

class aaa implements Serializable{
    private String abc;

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }
}

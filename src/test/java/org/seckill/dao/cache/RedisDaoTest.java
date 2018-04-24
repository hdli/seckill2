package org.seckill.dao.cache;

import org.junit.Test;
import org.seckill.BaseTest;
import org.seckill.dao.SeckillDao;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class RedisDaoTest extends BaseTest {
    private long id = 1001;
    @Autowired
    private RedisDao redisDao;

    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void getSeckill() throws Exception {
        //get and put
        Seckill seckill = redisDao.getSeckill(id);
        if (seckill == null) {
            seckill = seckillDao.queryById(id);
            if (seckill != null) {
                String result = redisDao.putSeckill(seckill);
                System.out.println(result);
                seckill = redisDao.getSeckill(id);
                System.out.println(seckill);
            }
        }
        System.out.println(seckill);
    }

}
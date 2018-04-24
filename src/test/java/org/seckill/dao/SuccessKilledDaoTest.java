package org.seckill.dao;

import org.junit.Test;
import org.seckill.BaseTest;
import org.seckill.entity.SuccessKilled;

import javax.annotation.Resource;

public class SuccessKilledDaoTest extends BaseTest {
    @Resource
    private SuccessKilledDao successKilledDao;
    @Test
    public void insertSuccessKilled() throws Exception {
        long seckillId=1000L;
        long userPhone=13476191877L;
        int insertCount=successKilledDao.insertSuccessKilled(seckillId,userPhone);
        System.out.println("insertCount="+insertCount);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long seckillId=1000L;
        long userPhone=13476191877L;
        SuccessKilled successKilled=successKilledDao.queryByIdWithSeckill(seckillId,userPhone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }

}
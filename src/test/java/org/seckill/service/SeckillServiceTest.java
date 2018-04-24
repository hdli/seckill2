package org.seckill.service;

import org.junit.Test;
import org.seckill.BaseTest;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class SeckillServiceTest extends BaseTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;
    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> seckills=seckillService.getSeckillList();
        logger.info("list={}",seckills);
    }

    @Test
    public void getById() throws Exception {
        long seckillId=1000;
        Seckill seckill=seckillService.getById(seckillId);
        logger.info("seckill={}",seckill);
    }
    ////完整逻辑代码测试，注意可重复执行
    @Test
    public void exportSeckillUrl() throws Exception {
        long id=1000;
        Exposer exposer=seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()){
            logger.info("exposer={}",exposer);
            String md5=exposer.getMd5();
            long phone=18703818846L;
            try {
                SeckillExecution seckillExecution= seckillService.executeSeckill(id,phone,md5);
                logger.info("SeckillExecution={}",seckillExecution);
            }catch (RepeatKillException e){
                logger.error(e.getMessage());
            }catch (SeckillCloseException e){
                logger.error(e.getMessage());
            }
        }else {
            logger.warn("exposer={}",exposer);
        }
    }

    @Test
    public void executeSeckillProcedure(){
        long seckillId=1001;
        long phone=136123456;
        Exposer exposer=seckillService.exportSeckillUrl(seckillId);
        if(exposer.isExposed()){
            String md5=exposer.getMd5();
            SeckillExecution seckillExecution=seckillService.executeSeckillProcedure(seckillId,phone,md5);
            logger.info(seckillExecution.getStateInfo());
        }
    }

}
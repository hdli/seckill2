package org.seckill.ehcache;

import org.junit.Test;
import org.seckill.BaseTest;
import org.seckill.service.ehcache.EhcacheService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hdli on 2018-3-13.
 */
public class EhcacheServiceTest extends BaseTest {
    @Autowired
    private EhcacheService ehcacheService;

    @Test
    public void testTimestamp() throws InterruptedException {
        System.out.println("第一次调用：" + ehcacheService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + ehcacheService.getTimestamp("param"));
        Thread.sleep(4000);
        System.out.println("再过4秒之后调用：" + ehcacheService.getTimestamp("param"));
    }

    @Test
    public void testCache(){
        String key = "lisi";
        String value = ehcacheService.getDataFromDB(key); //从数据库中获取数据...
        System.out.println("第一次获取值："+value);
        String value2 = ehcacheService.getDataFromDB(key);// 从缓存中获取数据，所以不执行该方法体
        System.out.println("第二次获取值："+value2);
        String value4 = ehcacheService.refreshData(key);  //更新缓存中的数据，
        System.out.println("更新缓存中"+key+"的值为："+value4);
        String value3 = ehcacheService.getDataFromDB(key); //从缓存中获取数据，所以不执行该方法体
        System.out.println("第三次获取值："+value3);
        ehcacheService.removeDataAtDB(key); // 从数据库中删除数据
        System.out.println("删除");
        String value5 = ehcacheService.getDataFromDB(key);
        System.out.println("第四次获取值："+value5);



    }


}

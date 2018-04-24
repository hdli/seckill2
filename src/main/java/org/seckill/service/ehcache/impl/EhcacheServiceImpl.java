package org.seckill.service.ehcache.impl;

import org.seckill.service.ehcache.EhcacheService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by hdli on 2018-3-13.
 */
@Service
public class EhcacheServiceImpl implements EhcacheService {

    @Cacheable(cacheNames = {"testNon1"},key = "#param")
    public String getTimestamp(String param) {
        System.out.println("从数据库中获取数据...");
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }
    //保存缓存   value与cacheNames起到的作用是一样的
    @Cacheable(value = {"testNon1"},key = "#key")
    public String getDataFromDB(String key) {
        System.out.println("从数据库中获取数据...");
        return key + ":" + String.valueOf(Math.round(Math.random()*1000000));
    }
    //将缓存保存进testNon1中，并当参数key的长度小于12时才保存进缓存，默认使用参数值及类型作为缓存的key
    @Cacheable(cacheNames = {"testNon1"},key = "#key",condition = "#key<12")
    public String getDataFromDB2(String key){
        System.out.println("从数据库中获取数据...");
        return key + ":" + String.valueOf(Math.round(Math.random()*1000000));
    }

    //删除缓存
    @CacheEvict(cacheNames = {"testNon1"},key = "#key")
    public void removeDataAtDB(String key) {
        System.out.println("从数据库中删除数据"+key);
    }
    //更新缓存
    //与@Cacheable不同，@CachePut不仅会缓存方法的结果，还会执行方法的代码段。它支持的属性和用法都与@Cacheable一致。
    @CachePut(cacheNames = {"testNon1"},key = "#key")
    public String refreshData(String key) {
        System.out.println("更新缓存:"+ key);
        return key + ":" + String.valueOf(Math.round(Math.random()*1000000));
    }

    //删除testNon1 中的所有缓存
    @CacheEvict(cacheNames = {"testNon1"},allEntries = true)
    public void removeAllCache(){
        System.out.println("删除所有缓存");
    }
}

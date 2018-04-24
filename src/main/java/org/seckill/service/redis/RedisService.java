package org.seckill.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * Created by hdli on 2018-3-5.
 */
@Service
public class RedisService {

    @Autowired @Qualifier("redis4Temp")
    private RedisTemplate redis4Temp;

    /**
     * 添加String
     * @param key
     * @param value
     */
    public void addValue(String key,Object value){
        ValueOperations valueOperations = redis4Temp.opsForValue();
        valueOperations.set(key,value);
    }

}

package org.seckill.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by hdli on 2018-5-24.
 */
public class GetProperties {
    /**
     *
     * @param path   .properties的具体路径
     * @return
     * @throws Exception
     */
    public static Map<String,String> getP(String path) throws Exception{
        Resource resource = new ClassPathResource(path);
        Properties props = PropertiesLoaderUtils.loadProperties(resource);
        Map<String,String> param = new HashMap<String,String>((Map) props);
        return param;
    }
}

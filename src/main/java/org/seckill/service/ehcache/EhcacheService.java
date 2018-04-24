package org.seckill.service.ehcache;

/**
 * Created by hdli on 2018-3-13.
 */
public interface EhcacheService {

    // 测试失效情况，有效期为5秒
    public String getTimestamp(String param);

    public String getDataFromDB(String key);

    public String getDataFromDB2(String key);

    public void removeDataAtDB(String key);

    public String refreshData(String key);

    public void removeAllCache();



}

package com.yimoxiamu.blogback.redis;

import com.yimoxiamu.blogback.util.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisClient
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/8/31 14:05
 * @VERSION 1.0
 **/
@Component
public class RedisClient {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RedisClient.class);
    @Autowired(required = false)
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 获取缓存值
     * @param cacheKey
     * @return
     */
    public String getCacheValue(String cacheKey) {
        String cacheValue =null;
        try {
            cacheValue = (String) redisTemplate.opsForValue().get(cacheKey);
        } catch (Exception e) {
            log.error("redis获取数据异常{}", e.getMessage());
        }
        return cacheValue;
    }

    /**
     * 设置缓存值
     * @param key
     * @param value
     */
    public void setCacheValue(String key, String value) {
        try {
            if(exists(key)){
                delCacheByKey(key);
            }
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            log.error("redis设置数据异常{}", e.getMessage());
        }
    }

    /**
     * 设置多组缓存值
     * @param
     */
    public void setMultiCacheValue(Map<String, String> redisMap) {
        redisTemplate.opsForValue().multiSet(redisMap);
    }

    /**
     * 设置缓存值并设置有效期
     * @param key
     * @param value
     */
    public void setCacheValueForTime(String key, String value, long time) {
        if(exists(key)){
            delCacheByKey(key);
        }
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    /**
     * 删除key值
     * @param key
     */
    public void delCacheByKey(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
//      redisTemplate.opsForHash().delete(key);
    }

    /**
     * 删除keys值
     * @param keys
     */
    public void delCacheByKey(Set<String> keys) {
        redisTemplate.opsForValue().getOperations().delete(keys);
    }
    /**
     * 获取token的有效期
     * @param key
     */
    public long getExpireTime(String key) {
        long time = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        return time;
    }

    /**
     * 设置token的有效期
     * @param key
     * @return
     */
    public boolean setExpireTime(String key, long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * @Title exists
     * @Description 判断key是否存在
     * @return boolean
     */
    public boolean exists(final String key) {
        return ((Boolean) redisTemplate.execute(new RedisCallback<Object>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.exists(key.getBytes());
            }
        })).booleanValue();
    }


    /**
     * @return the redisTemplate
     */
    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }
}

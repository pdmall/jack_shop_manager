package com.pdkj.jackmanager.service;

import com.pdkj.jackmanager.dao.ShopDao;
import com.pdkj.jackmanager.dao.SysUserDao;
import com.pdkj.jackmanager.dao.UserDao;
import com.pdkj.jackmanager.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

public class BaseService<T extends BaseDao> {

    private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    SysUserDao sysUserDao;

    @Resource
    ShopDao shopDao;

    @Resource
    UserDao userDao;

    @Autowired
    BannerDao bannerDao;
    @Resource
    CouponDao couponDao;

    public Object getCache(String key) {
        Object value = null;
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            value = operations.get(key);
        }
        return value;
    }

    public void setCache(String key, Object value, int seconds) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value, seconds, TimeUnit.SECONDS);
    }

    public void setCache(String key, Object value) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value, 10, TimeUnit.SECONDS);
    }

}

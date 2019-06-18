/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Guava
 * Author:   lixuanfeng
 * Date:     2019/6/16 上午9:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.hyperchain.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/16
 * @since 1.0.0
 */
@Service
//@Scope("singleton")//默认是单例(singleton),更改为多例(prototype)
@Slf4j
public class Guava {

    // 在需要的地方 直接注解引入，则将从缓存中数据数据，如果缓存中没有则将从redis中获取
    @Autowired
    private RedisService redisService;

    private LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(20, TimeUnit.MINUTES)
            .maximumSize(1000)
            .build(new CacheLoader<String, Object>() {
                @Override
                public Object load(String s) throws Exception {
                    log.info("从redis中获取数据");
                    Object o = redisService.get(s);
                    if (o == null) {
                        o = new Object();
                    }
                    return o;
                }
            });

    public Object get(String key) {
        try {
            return cache.get(key);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
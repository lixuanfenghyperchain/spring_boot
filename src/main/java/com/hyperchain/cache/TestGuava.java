/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: TestGuava
 * Author:   lixuanfeng
 * Date:     2019/6/15 下午11:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.hyperchain.vo.User;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/15
 * @since 1.0.0
 */
public class TestGuava {

    private LoadingCache<String, User> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(20, TimeUnit.MINUTES)
            .maximumSize(1000)
            .build(new CacheLoader<String, User>() {
                @Override
                public User load(String s) throws Exception {
                    System.out.println("模拟从数据库中读取");
                    User user = User.builder().userId("sss").psw("ss").name("lxf").role("admin").build();
                    if (user == null) {
                        user = new User();
                    }
                    return user;
                }
            });

    public static void main(String[] args) {

        TestGuava testGuava = new TestGuava();
        testGuava.getUser("sss");

    }

    public User getUser(String userId) {
        User user = null;
        try {
            for (int i = 0; i < 10; i++) {
                user = cache.get("sss" + i);
                System.out.println(user);
            }
            System.out.println("再次获取");
            for (int i = 0; i < 10; i++) {
                user = cache.get("sss" + i);
                System.out.println(user);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return user;
    }
}
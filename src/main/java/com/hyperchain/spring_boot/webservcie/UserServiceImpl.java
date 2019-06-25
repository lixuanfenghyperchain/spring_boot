package com.hyperchain.spring_boot.webservcie;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.jws.WebService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Jerry
 * @ClassName:UserServiceImpl
 * @Description:测试服务接口实现类
 * @date:2018年4月10日下午3:58:58
 */
@WebService(serviceName = "UserService",//对外发布的服务名
        targetNamespace = "http://service.demo.example.com"//指定你想要的名称空间，通常使用使用包名反转
        // endpointInterface ="com.hyperchain.spring_boot.UserService"
)//服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
@Component
public class UserServiceImpl implements UserService {

    private Map<String, User> userMap = new HashMap<String, User>();

    public UserServiceImpl() {
        System.out.println("向实体类插入数据");
        User user = new User();
        user.setUserId("1");
        user.setUserName("test1");
        user.setEmail("Jerry@163.xom");
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("2");
        user.setUserName("test2");
        user.setEmail("Jerryfix@163.xom");
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("3");
        user.setUserName("test3");
        user.setEmail("Jerryfix@163.xom");
        userMap.put(user.getUserId(), user);
    }

    public String getUserName(String userId) {
        return "userId为：" + userId;
    }

    public User getUser(String userId) {
        System.out.println("userMap是:" + userMap);
        return userMap.get(userId);
    }

}
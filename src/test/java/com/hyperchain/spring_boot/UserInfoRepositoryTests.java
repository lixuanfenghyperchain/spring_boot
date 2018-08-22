/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: UserInfoRepositoryTests
 * Author:   lixuanfeng
 * Date:     2018/8/7 下午3:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot;

import com.hyperchain.spring_boot.dao.AddressRepository;
import com.hyperchain.spring_boot.dao.UserInfoRepository;
import com.hyperchain.spring_boot.entitiy.ViewInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/8/7
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTests {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private AddressRepository addressRepository;

//    @Before
//    public void init() {
//        Address addr0 = new Address(null, "fasd", "fas", "fsa", "fsa", "fas", "fsa");
//        Address addr1 = new Address(null, "fasd", "fas", "fsa", "fsa", "fas", "fsa");
//        Address addr2 = new Address(null, "fasd", "fas", "fsa", "fsa", "fas", "fsa");
//        addressRepository.save(addr1);
//        addressRepository.save(addr2);
//
//        UserInfo user1 = new UserInfo(null, "zs", 22, "male", "1009710303@qq.com", addr1.getAddressId());
//        UserInfo user2 = new UserInfo(null, "zs", 22, "male", "1009710303@qq.com", addr1.getAddressId());
//        userInfoRepository.save(user1);
//        userInfoRepository.save(user2);
//    }

    @Test
    public void deleteAll() {
        userInfoRepository.deleteAll();

        addressRepository.deleteAll();
    }

    @Test
    public void testQuery() {
        List<ViewInfo> viewInfos = userInfoRepository.findViewInfo();
        for (ViewInfo viewInfo : viewInfos) {
            System.out.println(viewInfo.getUserInfo());
            System.out.println(viewInfo.getAddress());
            System.out.println("==================");
            System.out.println(viewInfo);
        }
    }

}
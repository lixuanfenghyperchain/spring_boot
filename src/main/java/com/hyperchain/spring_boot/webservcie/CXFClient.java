/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: CXFClient
 * Author:   lixuanfeng
 * Date:     2019/6/25 下午9:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.webservcie;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/6/25
 * @since 1.0.0
 */
public class CXFClient {


    public static void main(String[] args) {
        // 创建动态客户端
//        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
//        Client client = dcf.createClient("http://127.0.0.1:9090/soap/user?wsdl");
//        Object[] objects = new Object[]{};
//        try {
//            objects = client.invoke("getUserName", "1");
//            List<Object> objects1 = Arrays.asList(objects);
//            System.out.println(objects1.get(0));
//        } catch (java.lang.Exception e) {
//            e.printStackTrace();
//        }
//    }


        try {
            // 接口地址
            String address = "http://127.0.0.1:9090/soap/user?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(UserService.class);
            // 创建一个代理接口实现
            UserService cs = (UserService) jaxWsProxyFactoryBean.create();
            // 数据准备
            String id = "2";
            // 调用代理接口的方法调用并返回结果
            Object result = cs.getUser(id);
            System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
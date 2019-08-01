/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: CSDNSchedul
 * Author:   lixuanfeng
 * Date:     2019/8/1 上午10:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.schedul;

import com.hyperchain.spring_boot.util.HttpUtil;
import com.hyperchain.spring_boot.util.SingleThreadPool;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/8/1
 * @since 1.0.0
 */
@Component
public class CSDNSchedul {

    private static ExecutorService threadPool = SingleThreadPool.getInstance();

    @Scheduled(fixedRate = 60 * 1000)
    void doGet() {
        List<String> str = StringConstant.str();
        for (int i = 0; i < str.size(); i++) {
            final int index = i;
            threadPool.execute(() -> HttpUtil.doGet(StringConstant.urlBase + str.get(index)));
        }
    }
}
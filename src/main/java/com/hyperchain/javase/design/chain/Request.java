/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: Request
 * Author:   lixuanfeng
 * Date:     2019/3/28 上午10:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.design.chain;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/3/28
 * @since 1.0.0
 */
@Data
public class Request {


    private String requestType;

    private String requestContent;

    private int number;
}
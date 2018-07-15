/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: BaseResult
 * Author:   lixuanfeng
 * Date:     2018/7/15 下午5:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/7/15
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult<T> {
    //返回的响应码
    private int code;
    //返回的响应信息
    private String message;
    //返回的数据
    private T data;
}
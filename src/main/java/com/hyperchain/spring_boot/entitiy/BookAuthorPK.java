/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: BookAuthorPK
 * Author:   lixuanfeng
 * Date:     2018/8/7 下午4:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.entitiy;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/8/7
 * @since 1.0.0
 */
@Data
public class BookAuthorPK implements Serializable {
    private static final long serialVersionUID = -1158141803682305656L;

    private String bookId;

    private String authorId;
}
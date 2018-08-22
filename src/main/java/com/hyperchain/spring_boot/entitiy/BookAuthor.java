/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: BookAuthor
 * Author:   lixuanfeng
 * Date:     2018/8/7 下午4:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/8/7
 * @since 1.0.0
 */
@Entity
@Table(name = "book_author")
@AllArgsConstructor
@NoArgsConstructor
@Data
//联合主键
@IdClass(BookAuthorPK.class)
public class BookAuthor {


    @Id
    @Column(length = 40)
    private String bookId;

    @Id
    @Column(length = 40)
    private String authorId;


}
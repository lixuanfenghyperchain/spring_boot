/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: Book
 * Author:   lixuanfeng
 * Date:     2018/7/15 下午8:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
@Table(name = "book")
@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "boooName", nullable = false)
    private String book_name;

    @Column(name = "onlineDate", nullable = false)
    private String noline_date;

    @Column(name = "auth", nullable = false)
    private String auth;

    @Column(name = "detail", nullable = false)
    private String detail;
}
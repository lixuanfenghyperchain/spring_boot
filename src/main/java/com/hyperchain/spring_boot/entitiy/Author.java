/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: Author
 * Author:   lixuanfeng
 * Date:     2018/8/7 下午4:15
 * Description: 作者
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 〈一句话功能简述〉<br>
 * 〈作者〉
 *
 * @author lixuanfeng
 * @create 2018/8/7
 * @since 1.0.0
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
    @Id
    @GeneratedValue(generator = "id_uuid")
    @GenericGenerator(name = "id_uuid", strategy = "uuid")
    @Column(length = 40)
    private String id;

    private String name;

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: CannotHaveBlank
 * Author:   lixuanfeng
 * Date:     2018/7/22 下午10:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.config.verification;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/7/22
 * @since 1.0.0
 */
//注解能放的位置
//注解的保留策略
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
/* 验证注解通过 自定义验证类 实行验证 在这个类必须实现 ConstraintValidator<?,?>接口
 * 第一个泛型 是本注解的名称
 * 第二个泛型 是验证的对象类型
 *
 */
@Constraint(validatedBy = {CannotHaveBlankValidator.class})
public @interface CannotHaveBlank {
    //默认错误消息
    String message() default "不能包含空格";

    //分组
    Class<?>[] groups() default {};

    //负载
    Class<? extends Payload>[] payload() default {};

    //指定多个时使用
    @Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        CannotHaveBlank[] value();
    }

}
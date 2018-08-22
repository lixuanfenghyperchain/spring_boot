/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: CannotHaveBlankValidator
 * Author:   lixuanfeng
 * Date:     2018/7/22 下午11:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.config.verification;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/7/22
 * @since 1.0.0
 */
public class CannotHaveBlankValidator implements ConstraintValidator<CannotHaveBlank, String> {
    @Override
    public void initialize(CannotHaveBlank constraintAnnotation) {
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //null时不进行校验
        if (value != null && value.contains(" ")) {
            //获取默认提示信息
            String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
            System.out.println("default message :" + defaultConstraintMessageTemplate);
            //禁用默认提示信息
            context.disableDefaultConstraintViolation();
            //设置提示语
            context.buildConstraintViolationWithTemplate("can not contains blank").addConstraintViolation();
            return false;
        }
        return true;
    }
}
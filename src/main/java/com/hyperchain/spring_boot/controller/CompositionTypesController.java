/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: CompositionTypesController
 * Author:   lixuanfeng
 * Date:     2018/7/24 下午6:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/7/24
 * @since 1.0.0
 */
@Api(value = "type", description = "辅导类型")
@RestController
//@Valid
@Validated
@RequestMapping(value = "type")
@Slf4j
public class CompositionTypesController {
    @ApiOperation(value = "新增辅导类型", notes = "新增辅导类型")
    @PostMapping(value = "addCompostionTyp1e")
    public String addCompostionTyp1e(@ApiParam(value = "成绩") @Max(value = 60, message = "得分必须小于60") @RequestParam int score,
                                     @ApiParam(value = "年龄") @Min(value = 3, message = "年龄大于3岁") @RequestParam int age,
                                     @ApiParam(value = "辅导作文类型") @NotNull(message = "辅导作文类型不能为空") @RequestParam(required = false) String name) {
        //校验
        log.info(String.valueOf(age));
        return "ok";
    }

}
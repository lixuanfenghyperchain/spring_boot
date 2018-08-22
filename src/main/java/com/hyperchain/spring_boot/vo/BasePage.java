//package com.hyperchain.spring_boot.vo;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.domain.Page;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Function;
//
///**
// * @author chenmingming
// * @date 2018/6/21
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class BasePage<R> {
//    private Integer totalPages;
//
//    private Long totalElements;
//
//    private List<R> data;
//
//    public <T> BasePage(Page<T> source, Function<T,R> function){
//        if(function == null){
//            throw new RuntimeException("转换失败");
//        }
//        this.totalElements = source.getTotalElements();
//        this.totalPages = source.getTotalPages();
//        this.data = new ArrayList<>();
//        source.getContent().forEach(e ->{
//            data.add(function.apply(e));
//        });
//    }
//
//    public BasePage(Page<R> source){
//        this.totalPages = source.getTotalPages();
//        totalElements = source.getTotalElements();
//        this.data = source.getContent();
//    }
//}

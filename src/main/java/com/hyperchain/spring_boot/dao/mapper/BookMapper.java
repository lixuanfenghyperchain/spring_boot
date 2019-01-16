package com.hyperchain.spring_boot.dao.mapper;

import com.hyperchain.spring_boot.entitiy.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {
    @Select("select * from book where name = #{name}")
    Book findBookrByName(@Param("name") String name);
}

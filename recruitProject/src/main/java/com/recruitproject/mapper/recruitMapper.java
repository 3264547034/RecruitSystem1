package com.recruitproject.mapper;

import com.recruitproject.pojo.job;
import com.recruitproject.pojo.recruit;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface recruitMapper {
    //删
    @Delete("delete from recruit where jobseekerId = #{jobseekerId}")
    void deleteRecruit(Integer id);
    //改
    void updateRecruit(recruit recruit);
    //查
    //查询所有
    List<recruit> selectAll();
    //根据条件查询
    List<recruit> selectRecruit(recruit recruit);
}

package com.recruitproject.mapper;

import com.recruitproject.pojo.job;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface jobMapper {

    //增
    @Insert("insert into job(id,name,techtype,num,dptId) values (#{id},#{name},#{techtype},#{num},#{dptId})")
    void insertJob(job job);
    //删
    @Delete("delete from job where id = #{id}")
    void deleteJob(Integer id);
    //改
    void updateJob(job job);
    //查
    List<job> selectJob(job job);
    List<job> selectAll();


}

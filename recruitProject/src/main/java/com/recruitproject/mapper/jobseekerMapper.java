package com.recruitproject.mapper;

import com.recruitproject.pojo.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface jobseekerMapper {
    //增
    @Insert("insert into jobseeker(name,sex,age,degree,major,jobId,image) values(#{name},#{sex},#{age},#{degree},#{major},#{jobId},#{image})")
     void insertJobseeker(jobseeker jobseeker);
    //删
    @Delete("delete from jobseeker where id = #{id}")
    void deleteJobseeker(Integer id);
    //改
    void updateJobseeker(jobseeker jobseeker);
    //查
    List<jobseeker> selectJobseeker(jobseeker jobseeker);
    @Select("select jobseeker.id,jobseeker.name,age,sex,image,major,degree,job.id as jobId,job.name as jobName,recruit.pass as pass from jobseeker join job on jobseeker.jobId = job.id join recruit on jobseeker.id = recruit.jobseekerId")
    List<jobseeker> selectAll();
    //存储过程

}

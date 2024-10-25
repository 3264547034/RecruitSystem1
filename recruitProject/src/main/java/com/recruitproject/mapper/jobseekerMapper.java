package com.recruitproject.mapper;

import com.github.pagehelper.Page;
import com.recruitproject.anno.AutoFill;
import com.recruitproject.enumeration.operationType;
import com.recruitproject.pojo.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface jobseekerMapper {
    //增
    @AutoFill(operationType.insert)
    @Insert("insert into jobseeker(name,sex,age,degree,major,jobId,image,createTime,updateTime) values(#{name},#{sex},#{age},#{degree},#{major},#{jobId},#{image},#{createTime},#{updateTime})")
     void insertJobseeker(jobseeker jobseeker);
    //删
    @Delete("delete from jobseeker where id = #{id}")
    void deleteJobseeker(Integer id);
    //改
    @AutoFill(operationType.update)
    void updateJobseeker(jobseeker jobseeker);
    //查
    List<jobseeker> selectJobseeker(jobseeker jobseeker);
    @Select("select jobseeker.id,jobseeker.name,age,sex,image,major,degree,job.id as jobId,job.name as jobName,recruit.pass as pass from jobseeker join job on jobseeker.jobId = job.id join recruit on jobseeker.id = recruit.jobseekerId")
    List<jobseeker> selectAll();

    Page<jobseeker> pageQuery(jobseekerPageQueryDTO jobseekerPageQueryDTO);
    //存储过程

}

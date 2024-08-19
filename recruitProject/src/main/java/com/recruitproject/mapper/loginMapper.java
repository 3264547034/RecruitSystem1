package com.recruitproject.mapper;

import com.recruitproject.pojo.jobseekerAccount;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface loginMapper {

    @Select("select * from jobseeker_account where uid = #{uid} and password = #{password}")
    jobseekerAccount login(jobseekerAccount jobseekerAccount);
}

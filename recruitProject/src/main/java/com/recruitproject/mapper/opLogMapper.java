package com.recruitproject.mapper;

import com.recruitproject.pojo.LogInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import javax.xml.crypto.Data;
import java.time.LocalDate;

@Mapper
public interface opLogMapper {
    @Insert("insert into operationlog values(#{uid},#{opName},#{className},#{arg},#{time},#{data},#{returnValue})")
    void insertLog(LogInfo logInfo);

}

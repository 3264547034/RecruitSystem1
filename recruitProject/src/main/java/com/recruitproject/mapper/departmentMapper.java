package com.recruitproject.mapper;

import com.recruitproject.pojo.department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface departmentMapper {


    void insertDepartment(department department);
    @Delete("delete from department where id = #{id}")
    void deleteDepartment(Integer id);
    @Select("select * from department order by id")
    List<department> selectDepartment();
    void updateDepartment(department department);

}

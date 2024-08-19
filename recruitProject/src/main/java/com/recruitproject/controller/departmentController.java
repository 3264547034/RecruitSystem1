package com.recruitproject.controller;

import com.recruitproject.pojo.Result;
import com.recruitproject.pojo.department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.recruitproject.server.departmentServer;

import java.util.List;

@Slf4j
@RestController
@RestControllerAdvice
public class departmentController {
    @Autowired
    private departmentServer departmentServer;


    @PostMapping("/departments")
    public Result insert(@RequestBody department department){
        log.info("新增部门");
        departmentServer.insertDepartment(department);
        return Result.success();
    }
    @DeleteMapping("/departments/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除部门");
        departmentServer.deleteDepartment(id);
        return Result.success();
    }

    @GetMapping("/departments")
    public Result select(){
        log.info(" 查询所有部门信息");
        List<department> departments =  departmentServer.selectDepartment();
        return Result.success(departments);
    }

    @PutMapping("/departments")
    public Result update(@RequestBody department department){
        log.info("修改部门");
        departmentServer.updateDepartment(department);
        return Result.success();
    }

}

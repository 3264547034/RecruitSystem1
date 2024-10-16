package com.recruitproject.controller;

import com.recruitproject.anno.Log;
import com.recruitproject.pojo.Result;
import com.recruitproject.pojo.job;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.recruitproject.server.jobServer;

import java.util.List;
@RequestMapping("/jobs")
@RestController
@Slf4j
public class jobController {
    @Autowired
    private jobServer jobServer;

    @PostMapping
    @Log
    public Result insert(@RequestBody job job){
        log.info("添加岗位");
        jobServer.insertJob(job);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    @Log
    public Result delete(@PathVariable Integer id){
        log.info("删除岗位");
        jobServer.deleteJob(id);
        return Result.success();
    }

    @PutMapping
    @Log
    public Result update(@RequestBody job job){
        log.info("修改岗位");
        jobServer.updateJob(job);
        return Result.success();
    }
    @PostMapping("/search")
    public Result select(@RequestBody job job){
        log.info("查询岗位");
        List<job> jobs = jobServer.selectJob(job);
        return Result.success(jobs);
    }
    @GetMapping("/allJobs")
    public Result selectAll(){
        log.info("查询所有岗位信息");
        List<job> jobs = jobServer.selectAll();
        return Result.success(jobs);

    }
}



package com.recruitproject.controller.admin;

import com.recruitproject.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.recruitproject.server.procedureServer;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/procedure")

public class procedureController {
    @Autowired
    private procedureServer procedureServer;

    @PostMapping("/Audit")
    public Result Audit(@RequestBody Audit Audit){
        log.info("审核信息");
        String status = procedureServer.Audit(Audit);
        if(status == "success"){
            return Result.success();
        }
        else return Result.error("更新错误");
    }
    @PostMapping("/submitResume")
    public Result submitResume(@RequestBody jobseeker jobseeker){
        log.info("投简历");
        String status = procedureServer.submitResume(jobseeker);
        return Result.success(status);
    }

    @GetMapping("/infoJob")
    public Result info_job(){
        log.info("查看具体的招聘岗位信息");
        List<infoJob> info_jobs = procedureServer.jobInfo();
        return Result.success(info_jobs);
    }

    @GetMapping("/infoJobseeker")
    public Result info_jobseeker(){
        log.info("查看具体的应聘者信息");
        List<infoJobseeker> info_jobseekers = procedureServer.jobseekerInfo();
        return Result.success(info_jobseekers);
    }
    @PostMapping("/createHR")
    public Result createHR(@RequestBody HR hr){
        log.info("创建HR账号");
        String status  = procedureServer.createHR(hr);
        return Result.success(status);
    }

    @PostMapping("/createJobseeker")
    public Result createJobseeker(@RequestBody jobseekerAccount jobseekerAccount){
        log.info("创建求职者账号");
        String status  = procedureServer.createJobseeker(jobseekerAccount);
        return Result.success(status);
    }

}

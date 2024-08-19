package com.recruitproject.controller;

import com.recruitproject.pojo.*;
import com.recruitproject.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.recruitproject.server.jobseekerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/jobseekers")
public class jobseekerController {

    @Autowired
    private jobseekerServer jobseekerServer;
    //投简历接口
    @PostMapping
    public Result insert(@RequestBody jobseeker jobseeker){
        log.info("投简历");
        jobseekerServer.insertJobseeker(jobseeker);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除简历");
        jobseekerServer.deleteJobseeker(id);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody jobseeker jobseeker){
        log.info("修改简历");
        jobseekerServer.updateJobseeker(jobseeker);
        return Result.success();
    }
    @PostMapping("/search")
    public Result selectJobseeker(@RequestBody jobseeker jobseeker){
        log.info("查询简历");
        List<jobseeker> jobseekers = jobseekerServer.selectJobseeker(jobseeker);
        return Result.success(jobseekers);
    }
    @GetMapping("/allJobseekers")
    public Result selectAll(){
        log.info("查询所有简历");
        List<jobseeker> jobseekers = jobseekerServer.selectAll();
        return Result.success(jobseekers);
    }
    @Autowired
    private AliOSSUtils AliOSSUtils;
    @PostMapping("/upload")
    public Result uploadImage(MultipartFile file){
        log.info("上传应聘者图片");
        String url;
        try {
             url = AliOSSUtils.upload(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result.success(url);
    }




}

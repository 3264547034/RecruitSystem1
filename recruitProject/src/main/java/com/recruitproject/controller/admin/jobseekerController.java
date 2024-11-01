package com.recruitproject.controller.admin;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.recruitproject.anno.Log;
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
    /**
     * 投简历
     * @param jobseeker
     * @return
     */
    @PostMapping
    @Log
    public Result insert(@RequestBody jobseeker jobseeker){
        log.info("投简历");
        jobseekerServer.insertJobseeker(jobseeker);
        return Result.success();
    }

    /**
     * 删除简历
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @Log
    public Result delete(@PathVariable Integer id){
        log.info("删除简历");
        jobseekerServer.deleteJobseeker(id);
        return Result.success();
    }
    /**
     * 修改简历
     * @param jobseeker
     * @return
     */
    @PutMapping
    @Log
    public Result update(@RequestBody jobseeker jobseeker){
        log.info("修改简历");
        jobseekerServer.updateJobseeker(jobseeker);
        return Result.success();
    }
    /**
     * 查询简历
     * @param jobseeker
     * @return
     */
    @ApiOperationSupport(author = "AThena")
    @PostMapping("/search")
    public Result selectJobseeker(@RequestBody jobseeker jobseeker){
        log.info("查询简历");
        List<jobseeker> jobseekers = jobseekerServer.selectJobseeker(jobseeker);
        return Result.success(jobseekers);
    }

    /**
     * 查询所有简历
     * @return
     */
    @GetMapping("/allJobseekers")
    public Result selectAll(){
        log.info("查询所有简历");
        List<jobseeker> jobseekers = jobseekerServer.selectAll();
        return Result.success(jobseekers);
    }

    /**
     * 分页查询
     * @param jobseekerPageQueryDTO
     * @return
     */
    @ApiOperationSupport(author = "AThena")
    @Log
    @PostMapping("/pageQuery")
    public Result<pageResult> pageQuery(@RequestBody jobseekerPageQueryDTO jobseekerPageQueryDTO){
        log.info("分页查询数据:"+jobseekerPageQueryDTO);
        pageResult result = jobseekerServer.pageQuery(jobseekerPageQueryDTO);
        return Result.success(result);
    }
    @Autowired
    private AliOSSUtils AliOSSUtils;
    /**
     * 上传图片
     * @param file
     * @return
     */
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

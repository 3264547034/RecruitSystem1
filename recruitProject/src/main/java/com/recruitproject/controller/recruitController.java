package com.recruitproject.controller;

import com.recruitproject.pojo.Result;
import com.recruitproject.pojo.recruit;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.recruitproject.server.recruitServer;

import java.util.List;

@Slf4j
@RestController
//@RequestMapping("/recruit")
public class recruitController {
    @Autowired
    private recruitServer recruitServer;

    @DeleteMapping("/recruit/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除审核信息");
        recruitServer.deleteRecruit(id);
        return Result.success();
    }
    @PutMapping("/recruit")
    public Result update(@RequestBody recruit recruit){
        log.info("更新审核信息");
        recruitServer.updateRecruit(recruit);
        return Result.success();
    }
    @GetMapping("/recruit/allRecruit")
    public Result selectAll(){
        log.info("查询所有审核信息");
        List<recruit> recruits = recruitServer.selectAll();
        return Result.success(recruits);
    }
    @GetMapping("/recruit")
    public Result select(@RequestBody recruit recruit){
        log.info("查询审核信息");
        List<recruit> recruits = recruitServer.selectRecruit(recruit);
        return Result.success(recruits);
    }


}

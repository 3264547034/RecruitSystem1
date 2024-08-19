package com.recruitproject.server;

import com.recruitproject.pojo.job;
import org.springframework.stereotype.Service;

import java.util.List;


public interface jobServer {
    void insertJob(job job);
    void deleteJob(Integer id);
    void updateJob(job job);
    List<job> selectJob(job job);
    List<job> selectAll();
}

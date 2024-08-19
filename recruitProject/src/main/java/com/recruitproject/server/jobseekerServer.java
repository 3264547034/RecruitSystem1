package com.recruitproject.server;

import com.recruitproject.pojo.infoJob;
import com.recruitproject.pojo.job;
import com.recruitproject.pojo.jobseeker;
import com.recruitproject.pojo.selectJobseeker;

import java.util.List;

public interface jobseekerServer {
    void insertJobseeker(jobseeker jobseeker);
    void deleteJobseeker(Integer id);
    void updateJobseeker(jobseeker jobseeker);
    List<jobseeker> selectJobseeker(jobseeker jobseeker);
    List<jobseeker> selectAll();
}

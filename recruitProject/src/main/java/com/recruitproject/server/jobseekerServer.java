package com.recruitproject.server;

import com.recruitproject.pojo.*;

import java.util.List;

public interface jobseekerServer {
    void insertJobseeker(jobseeker jobseeker);
    void deleteJobseeker(Integer id);
    void updateJobseeker(jobseeker jobseeker);
    List<jobseeker> selectJobseeker(jobseeker jobseeker);
    List<jobseeker> selectAll();

    pageResult pageQuery(jobseekerPageQueryDTO jobseekerPageQueryDTO);
}

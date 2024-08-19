package com.recruitproject.server.Impl;

import com.recruitproject.pojo.infoJob;
import com.recruitproject.pojo.job;
import com.recruitproject.pojo.selectJobseeker;
import com.recruitproject.server.jobseekerServer;
import org.springframework.beans.factory.annotation.Autowired;
import com.recruitproject.mapper.jobseekerMapper;
import com.recruitproject.pojo.jobseeker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class jobseekerSeverImpl implements jobseekerServer {
    @Autowired
    private jobseekerMapper jobseekerMapper;
    @Override
    public void insertJobseeker(jobseeker jobseeker){


        jobseekerMapper.insertJobseeker(jobseeker);
    }
    @Override
    public void deleteJobseeker(Integer id) { jobseekerMapper.deleteJobseeker(id);}

    @Override
    public void updateJobseeker(jobseeker jobseeker){ jobseekerMapper.updateJobseeker(jobseeker);}
    @Override
    public List<jobseeker> selectJobseeker(jobseeker jobseeker){ return jobseekerMapper.selectJobseeker(jobseeker);}

    @Override
    public List<jobseeker> selectAll(){ return jobseekerMapper.selectAll();}


}

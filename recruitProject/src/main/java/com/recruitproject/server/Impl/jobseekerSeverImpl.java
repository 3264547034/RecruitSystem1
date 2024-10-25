package com.recruitproject.server.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.recruitproject.anno.Log;
import com.recruitproject.pojo.*;
import com.recruitproject.server.jobseekerServer;
import org.springframework.beans.factory.annotation.Autowired;
import com.recruitproject.mapper.jobseekerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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

    @Override
    public pageResult pageQuery(jobseekerPageQueryDTO jobseekerPageQueryDTO) {

        PageHelper.startPage(jobseekerPageQueryDTO.page, jobseekerPageQueryDTO.pageSize);
        Page<jobseeker> page = jobseekerMapper.pageQuery(jobseekerPageQueryDTO);
        long total = page.getTotal();
        List records = page.getResult();
        return new pageResult(total,records);
    }

}

package com.recruitproject.server.Impl;

import com.recruitproject.pojo.job;
import com.recruitproject.server.jobServer;
import org.springframework.beans.factory.annotation.Autowired;
import com.recruitproject.mapper.jobMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class jobServerImpl implements jobServer {
    @Autowired
    private jobMapper jobMapper;
    @Override
    public void insertJob(job job){jobMapper.insertJob(job);}
    @Override
    public void deleteJob(Integer id){jobMapper.deleteJob(id);}
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateJob(job job){jobMapper.updateJob(job);}
    @Override
    public List<job> selectJob(job job){
        return jobMapper.selectJob(job);
    }
    @Override
    public List<job> selectAll(){return jobMapper.selectAll();}
}

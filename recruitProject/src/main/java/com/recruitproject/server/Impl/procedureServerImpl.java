package com.recruitproject.server.Impl;

import com.recruitproject.pojo.*;
import com.recruitproject.server.procedureServer;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recruitproject.mapper.procedureMapper;

import java.util.List;

@Service

public class procedureServerImpl implements procedureServer {
    @Autowired
    private procedureMapper procedureMapper;
    @Override
    public String Audit(Audit Audit) {
        Integer jobseekerId = Audit.getJobseekerId();
        String  pass = Audit.getPass();
        return procedureMapper.Audit(jobseekerId,pass);
    }
    @Override
    public List<infoJob> jobInfo(){
        return procedureMapper.jobInfo();
    }

    @Override
    public List<infoJobseeker> jobseekerInfo(){ return procedureMapper.jobseekerInfo();}

    @Override
    public String createHR(HR hr){
        String id = hr.getUid();
        String password = hr.getPassword();
        return procedureMapper.createHR(id,password);
    }

    @Override
    public String createJobseeker(jobseekerAccount jobseekerAccount){
        String id = jobseekerAccount.getUid();
        String password = jobseekerAccount.getPassword();
        return procedureMapper.createJobseeker(id,password);
    }

    @Override
    public String submitResume(jobseeker jobseeker) {
        String sname = jobseeker.getName();
        String ssex = jobseeker.getSex();
        Integer sage = jobseeker.getAge();
        String smajor = jobseeker.getMajor();
        String sdegree = jobseeker.getDegree();
        String simage = jobseeker.getImage();
        Integer sjobId = jobseeker.getJobId();
        return procedureMapper.submitResume(sname,ssex,sage,sdegree,smajor,simage,sjobId);
    }
}

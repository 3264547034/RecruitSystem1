package com.recruitproject.server.Impl;

import com.recruitproject.pojo.jobseekerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recruitproject.server.loginServer;
import com.recruitproject.mapper.loginMapper;
@Service
public class loginSeverImpl implements loginServer{
    @Autowired loginMapper loginMapper;
    @Override
    public jobseekerAccount login(jobseekerAccount jobseekerAccount){
        return loginMapper.login(jobseekerAccount);
    }

}

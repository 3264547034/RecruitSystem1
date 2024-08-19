package com.recruitproject.server.Impl;

import com.recruitproject.pojo.recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recruitproject.server.recruitServer;
import com.recruitproject.mapper.recruitMapper;
import java.util.List;

@Service
public class recruitServerImpl implements recruitServer{
    @Autowired
    private recruitMapper recruitMapper;
    @Override
    public void deleteRecruit(Integer jobseekerId){ recruitMapper.deleteRecruit(jobseekerId);}
    @Override
    public void updateRecruit(recruit recruit){ recruitMapper.updateRecruit(recruit);}
    @Override
    public List<recruit> selectAll(){return recruitMapper.selectAll();}
    @Override
    public List<recruit> selectRecruit(recruit recruit){return recruitMapper.selectRecruit(recruit);};

}

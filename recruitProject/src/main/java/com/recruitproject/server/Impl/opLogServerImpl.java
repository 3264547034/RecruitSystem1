package com.recruitproject.server.Impl;

import com.recruitproject.pojo.LogInfo;
import com.recruitproject.server.opLogServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recruitproject.mapper.opLogMapper;
import javax.xml.crypto.Data;
import java.time.LocalDate;

@Service
public class opLogServerImpl implements opLogServer {
    @Autowired
    private opLogMapper opLogMapper;
    @Override
    public void insertLog(LogInfo logInfo){
        opLogMapper.insertLog(logInfo);
    }


}

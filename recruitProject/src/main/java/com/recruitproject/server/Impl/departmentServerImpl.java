package com.recruitproject.server.Impl;

import com.recruitproject.anno.Log;
import com.recruitproject.pojo.department;
import com.recruitproject.server.departmentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recruitproject.mapper.departmentMapper;

import java.util.List;

@Service
public class departmentServerImpl implements departmentServer {
    @Autowired
    private departmentMapper departmentMapper;

    @Override
    public void insertDepartment(department department){
        departmentMapper.insertDepartment(department);
    }
    @Override
    public void deleteDepartment(Integer id){
        departmentMapper.deleteDepartment(id);
    }

    @Override
    public List<department> selectDepartment(){
        return departmentMapper.selectDepartment();
    }

    @Override
    public void updateDepartment(department department){ departmentMapper.updateDepartment(department);}
}

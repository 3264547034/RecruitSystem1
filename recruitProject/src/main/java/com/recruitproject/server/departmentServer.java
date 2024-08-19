package com.recruitproject.server;

import com.recruitproject.pojo.department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface departmentServer {
    void insertDepartment(department department);
    void deleteDepartment(Integer id);
    List<department> selectDepartment();

    void updateDepartment(department department);
}

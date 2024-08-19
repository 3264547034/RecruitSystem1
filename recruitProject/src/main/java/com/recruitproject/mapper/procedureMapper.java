package com.recruitproject.mapper;

import com.recruitproject.pojo.Audit;
import com.recruitproject.pojo.infoJob;
import com.recruitproject.pojo.infoJobseeker;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Mapper

public interface procedureMapper {
    String Audit(Integer jobseekerId,String pass);

    List<infoJob> jobInfo();
    List<infoJobseeker> jobseekerInfo();
    String createHR(String id,String password);
    String createJobseeker(String id,String password);

    String submitResume(String sname, String ssex, Integer sage, String sdegree, String smajor, String simage, Integer sjobId);
}

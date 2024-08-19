package com.recruitproject.server;

import com.recruitproject.pojo.*;

import java.util.List;

public interface procedureServer {
    String Audit(Audit Audit);
    List<infoJob> jobInfo();
    List<infoJobseeker> jobseekerInfo();
    String createHR(HR hr);

    String createJobseeker(jobseekerAccount jobseekerAccount);

    String submitResume(jobseeker jobseeker);
}

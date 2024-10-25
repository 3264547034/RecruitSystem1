package com.recruitproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class jobseeker {
    public Integer id;
    public String name;
    public String sex;
    public Integer age;
    public String image;
    public String degree;
    public String major;
    public Integer jobId;
    public String jobName;
    public String pass;
    public LocalDateTime updateTime;
    public LocalDateTime createTime;
}

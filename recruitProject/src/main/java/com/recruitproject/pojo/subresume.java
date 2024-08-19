package com.recruitproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class subresume {
    public Integer id;
    public String name;
    public Integer age;
    public String sex;
    public String image;
    public String degree;
    public String major;
    public Integer jobId;
}

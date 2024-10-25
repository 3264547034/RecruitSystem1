package com.recruitproject.pojo;

import java.io.Serializable;
import java.time.LocalDate;

public class jobseekerPageQueryDTO implements Serializable {
    public String name;
    public String major;
    public String sex;
    public String degree;
    public int jobId;
    public int page;//页码
    public int pageSize;//每页的记录数
    public LocalDate update_time;
    public LocalDate create_time;

}

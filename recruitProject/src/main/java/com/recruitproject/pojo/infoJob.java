package com.recruitproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class infoJob {
    public Integer id;
    public String name;
    public String techtype;
    public Integer num;
    public String dptId;
    public String dptName;
    public String dptDuty;
}

package com.recruitproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class job {
    public Integer newId;
    public Integer id;
    public String name;
    public String techtype;
    public Integer num;
    public Integer dptId;
    public String dptName;
}

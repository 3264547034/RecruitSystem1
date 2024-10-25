package com.recruitproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
//分页查询对象
public class pageResult implements Serializable {
    private long total; //总记录数
    private List records;//返回的集合

}

package com.recruitproject.server;

import com.recruitproject.pojo.recruit;

import java.util.List;

public interface recruitServer {
    void deleteRecruit(Integer jobseekerId);
    void updateRecruit(recruit recruit);
    List<recruit> selectAll();
    List<recruit> selectRecruit(recruit recruit);


}

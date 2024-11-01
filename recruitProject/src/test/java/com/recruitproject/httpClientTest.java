package com.recruitproject;


import com.recruitproject.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@Slf4j
public class httpClientTest {
    @Autowired
    private HttpClientUtils httpClientUtils;
    @Test
    public void testGet() {
        String url = "http://localhost:8080/jobseekers/allJobseekers";
        String response = null;
        try {
            response = httpClientUtils.doGet(url,null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info(response);

    }



}

package com.recruitproject;


import com.recruitproject.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
public class httpClientTest {
    @Autowired
    private HttpClientUtil httpClientUtil;
    @Test
    public void testPost() {
        String url = "http://localhost:8080/login";
        String response;
        Map<String, String> params = new HashMap<>();
        params.put("uid","jobek2");
        params.put("password","123456");

        try {
            response = httpClientUtil.doPost4Json(url,params);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info(response);

    }



}

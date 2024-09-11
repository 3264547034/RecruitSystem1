package com.recruitproject.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor

public class LogInfo {
    public String uid;
    public String opName;
    public String className;
    public String arg;
    public Long time;
    public LocalDate data;
    public String returnValue;
}

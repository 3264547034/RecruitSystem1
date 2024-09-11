package com.recruitproject.server;

import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;

import com.recruitproject.pojo.LogInfo;
public interface opLogServer {
  void insertLog(LogInfo logInfo);
}

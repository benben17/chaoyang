package com.bank.manager.service;

import com.bank.manager.domain.log.SysLog;

import java.util.Date;
import java.util.List;

public interface SysLogService {

    long saveLog(SysLog sysLog);

    List<SysLog> getLogList(String startTime, String endTime);

}

package com.bank.manager.dao;

import com.bank.manager.domain.log.SysLog;

import java.util.Date;
import java.util.List;

public interface SysLogDao {
    /**
     * 登陆日志保存
     * @param sysLog
     * @return
     */
    long insertLog(SysLog sysLog);

    /**
     * 登陆日志查看
     * @param startTime
     * @param endTime
     * @return
     */
    List<SysLog> getOperationLogList(String startTime, String  endTime);

}

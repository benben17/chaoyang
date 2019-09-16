package com.bank.manager.log;

import com.bank.manager.domain.log.SysLog;

import java.util.Date;

public class SysLogFactory {


    /**
     * 创建操作日志
     */
    public static SysLog createOperationLog(long logType, String userName, String logName, String moduleName, String msg) {
        SysLog sysLog = SysLog.builder()
                .logType(logType)
                .logName(logName)
                .userName(userName)
                .moduleName(moduleName)
                .createTime(new Date())
                .msg(msg).build();
        return sysLog;
    }
}

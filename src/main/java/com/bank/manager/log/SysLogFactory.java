package com.bank.manager.log;

import com.bank.manager.domain.log.LogType;
import com.bank.manager.domain.log.LoginLog;
import com.bank.manager.domain.log.OperationLog;

import java.util.Date;

public class SysLogFactory {


    /**
     * 创建操作日志
     */
    public static OperationLog createOperationLog(String logType, Long userId, String logName,  String moduleName, String msg) {
        OperationLog operationLog = OperationLog.builder()
                .logType(logType)
                .logName(logName)
                .userId(userId)
                .moduleName(moduleName)
                .createTime(new Date())
                .message(msg).build();
        return operationLog;
    }

    /**
     * 创建登录日志
     */
    public static LoginLog createLoginLog(String logType, Long userId, String msg, String ip) {
        LoginLog loginLog = LoginLog.builder()
                .logType(logType)
                .userId(userId)
                .createTime(new Date())
                .message(msg)
                .ipAddress(ip)
                .build();

        return loginLog;
    }
}

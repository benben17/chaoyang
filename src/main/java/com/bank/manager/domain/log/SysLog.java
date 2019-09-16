package com.bank.manager.domain.log;

import lombok.*;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class SysLog {
    private long id;
    private String userName;
    // 1:登录日志 2:登出日志 3:操作日志 4:异常日志
    private long logType;
    private String logName;
    private String moduleName;
    private String ipAddress;
    private String successed;
    private Date createTime;
    private String msg;


}

package com.bank.manager.dao;

import com.bank.manager.domain.log.LoginLog;

import java.util.Date;
import java.util.List;

public interface LoginLogDao {
    /**
     * 登陆日志保存
     * @param loginLog
     * @return long
     */
    long insertLog(LoginLog loginLog);

    /**
     * 登陆日志查看
     * @param startTime
     * @param endTime
     * @return list
     */
    List<LoginLog> LoginLogList(Date startTime, Date endTime);


}

package com.bank.manager.service.impl;

import com.bank.manager.dao.SysLogDao;
import com.bank.manager.domain.log.SysLog;
import com.bank.manager.service.SysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private SysLogDao sysLogDao;

    @Override
    public long saveLog(SysLog sysLog) {
        sysLog.setCreateTime(new Date());
        return sysLogDao.insertLog(sysLog);
    }

    @Override
    public List<SysLog> getLogList(String startTime, String endTime) {
        return sysLogDao.getOperationLogList(startTime,endTime);
    }
}

package com.bank.manager.controller;

import com.bank.manager.common.CommonUtils;
import com.bank.manager.domain.log.SysLog;
import com.bank.manager.result.JsonResult;
import com.bank.manager.service.SysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@ResponseBody
public class SysLogController {
    final static Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private SysLogService sysLogService;

    @RequestMapping(value = "/api/log", method = RequestMethod.POST)
    public JsonResult saveOperationLog(@RequestBody SysLog sysLog) {
        sysLogService.saveLog(sysLog);
        log.info(sysLog.toString());
        return JsonResult.success(null);
    }

    @RequestMapping(value = "/api/log/{startTime}/{endTime}/{logType}", method = RequestMethod.GET)
    public JsonResult getOperationLog(@PathVariable("startTime") String startTime,
                                      @PathVariable("endTime") String endTime,
                                      @PathVariable("logType") String logType) {
        System.out.println(startTime);
        List<SysLog> sysLogs = sysLogService.getLogList(CommonUtils.strToDateLong(startTime), CommonUtils.strToDateLong(endTime),logType);
        return JsonResult.success(sysLogs);
    }

}

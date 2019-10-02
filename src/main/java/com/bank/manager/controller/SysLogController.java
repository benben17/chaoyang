package com.bank.manager.controller;

import com.bank.manager.common.CommonUtils;
import com.bank.manager.domain.log.SysLog;
import com.bank.manager.result.JsonResult;
import com.bank.manager.service.SysLogService;
import com.bank.manager.utils.IpUtil;
import com.bank.manager.utils.NetworkUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import java.util.List;

@RestController
@ResponseBody
public class SysLogController {
    final static Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private SysLogService sysLogService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/api/log", method = RequestMethod.POST)
    public JsonResult saveOperationLog(@RequestBody SysLog sysLog) {


        String clientIp = NetworkUtils.getIpAddress(request);
        sysLog.setIpAddress(clientIp);
        log.info(sysLog.toString());
        sysLogService.saveLog(sysLog);
        return JsonResult.success(null);
    }

    @RequestMapping(value = "/api/log/{startTime}/{endTime}", method = RequestMethod.GET)
    public JsonResult getOperationLog(@PathVariable("startTime") String startTime,
                                      @PathVariable("endTime") String endTime) {
        System.out.println(startTime);
        List<SysLog> sysLogs = sysLogService.getLogList(startTime, endTime);
        return JsonResult.success(sysLogs);
    }

}

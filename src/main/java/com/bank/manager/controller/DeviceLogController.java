package com.bank.manager.controller;

import com.bank.manager.common.CommonUtils;
import com.bank.manager.domain.sys.Device;
import com.bank.manager.result.JsonResult;
import com.bank.manager.service.DeviceLogService;
import com.bank.manager.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@ResponseBody
public class DeviceLogController {
    final static Logger log = LoggerFactory.getLogger(DeviceLogController.class);
    @Resource
    private DeviceLogService deviceLogService;

    @Resource
    private DeviceService deviceService;


    @RequestMapping(value = "/api/device/log/{startTime}/{endTime}/{deviceId}/{priority}", method = RequestMethod.GET)
    public JsonResult deleteDevice(@PathVariable("startTime") String startTime,
                                   @PathVariable("endTime") String endTime,
                                   @PathVariable("deviceId") long deviceId,
                                   @PathVariable("priority") long priority) {
        Device device = deviceService.getDeviceById(deviceId);
        String fromHost =device.getDeviceIp();
        log.info(String.format("search device log %s-%s %s %s ", startTime, endTime, fromHost, priority));
        return JsonResult.success(deviceLogService.getDeviceLogList(CommonUtils.strToDateLong(startTime),
                CommonUtils.strToDateLong(endTime), fromHost, priority));
    }
}

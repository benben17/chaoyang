package com.bank.manager.controller.device;

import com.bank.manager.common.CommonUtils;
import com.bank.manager.common.CountType;
import com.bank.manager.controller.UserController;
import com.bank.manager.domain.sys.Device;
import com.bank.manager.result.JsonResult;
import com.bank.manager.service.DeviceService;
import com.bank.manager.service.FwService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@ResponseBody
public class FwController {
    final static Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private FwService fwService;
    @Resource
    DeviceService deviceService;

    @RequestMapping(value = "/api/device/fw/attack/{type}/{deviceId}", method = RequestMethod.GET)
    public JsonResult getAttack(@PathVariable("type") long type, @PathVariable("deviceId") long deviceId) {
        String startTime = getStartTime(type);
        String deviceIp = getDeviceIp(deviceId);
        if (startTime != null) {
            return JsonResult.success(fwService.getAttackNum(startTime, deviceIp));
        } else {
            return JsonResult.fail(404, "变量错误");
        }
    }

    @RequestMapping(value = "/api/device/fw/load/{type}/{deviceId}", method = RequestMethod.GET)
    public JsonResult getDeviceLoad(@PathVariable("type") long type, @PathVariable("deviceId") long deviceId) {
        String startTime = getStartTime(type);
        String deviceIp = getDeviceIp(deviceId);
        if (startTime != null) {
            return JsonResult.success(fwService.getDeviceLoad(startTime, deviceIp));
        } else {
            return JsonResult.fail(404, "变量错误");
        }
    }

    @RequestMapping(value = "/api/device/fw/network/{type}/{deviceId}", method = RequestMethod.GET)
    public JsonResult getNetwork(@PathVariable("type") long type, @PathVariable("deviceId") long deviceId) {
        String startTime = getStartTime(type);
        String deviceIp = getDeviceIp(deviceId);
        if (startTime != null) {
            return JsonResult.success(fwService.getNetwork(startTime, deviceIp));
        } else {
            return JsonResult.fail(404, "变量错误");
        }
    }

    @RequestMapping(value = "/api/device/fw/threat/{type}/{deviceId}", method = RequestMethod.GET)
    public JsonResult getThreat(@PathVariable("type") long type, @PathVariable("deviceId") long deviceId) {
        String deviceIp = getDeviceIp(deviceId);
        String startTime = getStartTime(type);
        if (startTime != null) {
            return JsonResult.success(fwService.getThreat(startTime, deviceIp));
        } else {
            return JsonResult.fail(404, "变量错误");
        }
    }

    @RequestMapping(value = "/api/device/fw/top/user/{type}/{deviceId}", method = RequestMethod.GET)
    public JsonResult getTop10Threat(@PathVariable("type") long type, @PathVariable("deviceId") long deviceId) {
        String startTime = getStartTime(type);
        String deviceIp = getDeviceIp(deviceId);
        if (startTime != null) {
            return JsonResult.success(fwService.getTop10User(startTime, deviceIp));
        } else {
            return JsonResult.fail(404, "变量错误");
        }
    }

    @RequestMapping(value = "/api/device/fw/top/app/{type}/{deviceId}", method = RequestMethod.GET)
    public JsonResult getTop10App(@PathVariable("type") long type, @PathVariable("deviceId") long deviceId) {
        String startTime = getStartTime(type);
        String deviceIp = getDeviceIp(deviceId);
        if (startTime != null) {
            return JsonResult.success(fwService.getTop10App(startTime, deviceIp));
        } else {
            return JsonResult.fail(404, "变量错误");
        }
    }

    private String getStartTime(long type) {
        if (type == 0) { // 5分钟
            return CommonUtils.getBeforeTime(-5);
        } else if (type == 1) { //1小时
            return CommonUtils.getBeforeTime(-60);
        } else if (type == 2) { //2小时
            return CommonUtils.getBeforeTime(-120);
        } else if (type == 3) {  //4小时
            return CommonUtils.getBeforeTime(-240);
        } else if (type == 4) {  //一天
            return CommonUtils.getToday();
        } else {
            return null;
        }
    }

    private String getDeviceIp(long deviceId) {
        if (deviceId == 0) {
            return null;
        } else {
            Device device = deviceService.getDeviceById(deviceId);
            if (device == null) {
                return null;
            }
            return device.getDeviceIp();
        }
    }

}

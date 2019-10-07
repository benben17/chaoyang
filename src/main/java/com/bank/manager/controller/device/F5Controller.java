package com.bank.manager.controller.device;

import com.bank.manager.common.CommonUtils;
import com.bank.manager.controller.UserController;
import com.bank.manager.domain.sys.Device;
import com.bank.manager.result.JsonResult;
import com.bank.manager.service.DeviceService;
import com.bank.manager.service.F5Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@ResponseBody
public class F5Controller {

    final static Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private F5Service f5Service;
    @Resource
    DeviceService deviceService;

    @RequestMapping(value = "/api/device/f5/info/{deviceId}", method = RequestMethod.GET)
    public JsonResult getVsInfo(@PathVariable("deviceId") long deviceId) {

        String deviceIp = getDeviceIp(deviceId);

        log.info(deviceIp);
        return JsonResult.success(f5Service.getVsInfo(deviceIp));

    }

    @RequestMapping(value = "/api/device/f5/info/{type}/{deviceId}", method = RequestMethod.GET)
    public JsonResult getVsInfo(@PathVariable("type") long type, @PathVariable("deviceId") long deviceId) {
        String startTime = CommonUtils.getStartTime(type);
        String deviceIp = getDeviceIp(deviceId);

        log.info(deviceIp);
        if (startTime != null) {
            return JsonResult.success(f5Service.getVsRate(startTime, deviceIp));
        } else {
            return JsonResult.fail(404, "变量错误");
        }

    }


    @RequestMapping(value = "/api/device/f5/stat/{type}/{deviceId}/{vsName}", method = RequestMethod.GET)
    public JsonResult getVsStat(@PathVariable("type") long type, @PathVariable("deviceId") long deviceId,
                                @PathVariable("vsName") String vsName) {
        String startTime = CommonUtils.getStartTime(type);
        String deviceIp = getDeviceIp(deviceId);
        if (deviceIp == null ){
            vsName = null;
        }
        if (startTime != null) {
            return JsonResult.success(f5Service.getVsStatus(startTime, deviceIp,vsName));
        } else {
            return JsonResult.fail(404, "变量错误");
        }
    }

//    @RequestMapping(value = "/api/device/f5/request/fail/{type}", method = RequestMethod.GET)
//    public JsonResult getRequestFail(@PathVariable("type") long type) {
//        String startTime = CommonUtils.getStartTime(type);
////        String deviceIp = getDeviceIp(deviceId);
//        if (startTime != null) {
//            return JsonResult.success(f5Service.getRequestFail(startTime));
//        } else {
//            return JsonResult.fail(404, "变量错误");
//        }
//    }

    @RequestMapping(value = "/api/device/f5/detail/{type}/{vsName}", method = RequestMethod.GET)
    public JsonResult getRequestSuccess(@PathVariable("type") long type,@PathVariable("vsName") String vsName) {
        String startTime = CommonUtils.getStartTime(type);
//        String deviceIp = getDeviceIp(deviceId);
        if (startTime != null) {
            return JsonResult.success(f5Service.getRequestSuccess(startTime,vsName));
        } else {
            return JsonResult.fail(404, "变量错误");
        }
    }

    @RequestMapping(value = "/api/device/f5/request/rate/{type}/{vsName}", method = RequestMethod.GET)
    public JsonResult getRequestRate(@PathVariable("type") long type, @PathVariable String vsName) {
        String startTime = CommonUtils.getStartTime(type);
//        String deviceIp = getDeviceIp(deviceId);
        if (startTime != null) {
            return JsonResult.success(f5Service.getRequestRate(startTime, vsName));
        } else {
            return JsonResult.fail(404, "变量错误");
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

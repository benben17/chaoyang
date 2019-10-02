package com.bank.manager.controller;

import com.bank.manager.domain.sys.Config;
import com.bank.manager.result.JsonResult;
import com.bank.manager.service.sys.ConfigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@ResponseBody
public class ConfigController {


    @Resource
    private ConfigService configService;

    /**
     * 查询全局系统配置信息
     *
     * @return list
     */
    @RequestMapping(value = "/api/sys/config", method = RequestMethod.GET)
    public JsonResult getConfigs() {
        List<Config> configs = configService.getConfigList();

        return JsonResult.success(configs);
    }

    /**
     * 更新全局系统配置信息
     *
     * @param config config
     */
    @RequestMapping(value = "/api/sys/config", method = RequestMethod.PUT)
    public JsonResult modifyConfig(@RequestBody Config config) {
        configService.updateConfig(config);
        return JsonResult.success(null);
    }

}

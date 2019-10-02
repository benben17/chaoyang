package com.bank.manager.service.impl;

import com.bank.manager.dao.sys.ConfigDao;
import com.bank.manager.domain.sys.Config;
import com.bank.manager.service.sys.ConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Resource
    private ConfigDao configDao;

    @Override
    public List<Config> getConfigList() {
        return configDao.getConfigList();
    }

    @Override
    public void updateConfig(Config config) {
        config.setEditTime(new Date());
        configDao.updateConfig(config);
    }


}

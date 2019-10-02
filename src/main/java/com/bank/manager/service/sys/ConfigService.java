package com.bank.manager.service.sys;

import com.bank.manager.domain.sys.Config;

import java.util.List;

public interface ConfigService {
    List<Config> getConfigList();

    void updateConfig(Config config);

}

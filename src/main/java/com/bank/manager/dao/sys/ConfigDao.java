package com.bank.manager.dao.sys;


import com.bank.manager.domain.sys.Config;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Chunfu.Dong
 * @date 2019-08-03 15:03
 */
public interface ConfigDao {
    List<Map<String,String>> getConfig();

    List<Config> getConfigList();

    Long updateConfig(Config config);
}
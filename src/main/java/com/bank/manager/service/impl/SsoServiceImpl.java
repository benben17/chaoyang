package com.bank.manager.service.impl;

import com.bank.manager.common.CommonUtils;
import com.bank.manager.dao.SsoDao;
import com.bank.manager.domain.user.Sso;
import com.bank.manager.service.SsoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class SsoServiceImpl  implements SsoService {
    @Resource
    SsoDao ssoDao;
    @Override
    public Sso getUserInfo(String ipAddress) {

        return ssoDao.getUserInfo(ipAddress);
    }

    @Override
    public long insertUserInfo(Sso sso) {
        sso.setCreateTime(CommonUtils.getNowTime());
        return ssoDao.insertUserInfo(sso);
//        return 0;
    }

    @Override
    public long updateUserInfo(Sso sso) {
        return ssoDao.updateUserInfo(sso);
    }

    @Override
    public void deleteUserInfo(String ipAddress) {
        ssoDao.deleteUserInfo(ipAddress);
    }
}

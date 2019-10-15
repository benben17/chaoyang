package com.bank.manager.service;

import com.bank.manager.domain.user.Sso;

public interface SsoService {
    Sso getUserInfo(String ipAddress);

    long insertUserInfo(Sso sso);

    long updateUserInfo(Sso sso);

    void deleteUserInfo(String ipAddress);

}

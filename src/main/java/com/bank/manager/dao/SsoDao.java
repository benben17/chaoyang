package com.bank.manager.dao;

import com.bank.manager.domain.user.Sso;
import org.apache.ibatis.annotations.Param;

public interface SsoDao {
    Sso getUserInfo(@Param("ipAddress") String ipAddress);
    long insertUserInfo(Sso sso);
    long updateUserInfo(Sso sso);

}

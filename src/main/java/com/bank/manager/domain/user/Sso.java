package com.bank.manager.domain.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sso {

    long id;
    String userName;
    String password;
    String ipAddress;
    String createTime;

}

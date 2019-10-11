package com.bank.manager.domain.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sso {

    long id;
    String username;
    String password;
    String ipAddress;
    String createTime;

}

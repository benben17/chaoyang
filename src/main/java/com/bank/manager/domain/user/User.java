package com.bank.manager.domain.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * User
 */

@Getter
@Setter
public class User {
    private long id;
    private long roleId;
    private String roleName;
    private String userName;
    private String password;
    private String mobile;
    private String email;
    private String token;
    private Date loginTime;
    private long createUid;
    private long editUid;
    private Date createTime;
    private Date editTime;
    private String description;


}
package com.bank.manager.domain.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * User
 */

@Getter
@Setter
@Data
public class Role {
    private long id;
    private String roleName;
    private String access;
    private long createUid;
    private long editUid;
    private Date createTime;
    private Date editTime;
    private  String description;

}
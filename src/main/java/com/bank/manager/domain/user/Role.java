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
    private Long id;
    private String roleName;
    private String access;
    private Long createUid;
    private Long editUid;
    private Date createTime;
    private Date editTime;

}
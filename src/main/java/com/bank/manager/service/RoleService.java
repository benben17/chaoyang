package com.bank.manager.service;

import com.bank.manager.domain.user.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoleList();
    Role getUserAccess(long id);
    boolean updateRole(Role role);
    boolean insertRole(Role role);
    boolean deleteRoles(List ids);
    boolean checkRoleName(Role role);
}

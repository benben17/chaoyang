package com.bank.manager.service.sys;

import com.bank.manager.domain.user.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoleList();
    List<Role> getRoleAll();
    Role getUserAccess(long id);
    boolean updateRole(Role role);
    boolean insertRole(Role role);
    boolean deleteRoles(List ids);
    boolean checkRoleName(Role role);
}

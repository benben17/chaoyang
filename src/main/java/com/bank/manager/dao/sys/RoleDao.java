package com.bank.manager.dao.sys;

import com.bank.manager.domain.user.Role;

import java.util.List;

public interface RoleDao {
    /**
     * get role list
     * @return
     */
    List<Role> getRoleList();
    List<Role> getRoleAll();
    /**
     * get user role
     * @param id id
     * @return role
     */
    Role getUserAccess(long id);
    long updateRole(Role role);
    long insertRole(Role role);
    long deleteRoles(List ids);
    long checkRoleName(Role role);

}

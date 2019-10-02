package com.bank.manager.service.impl;

import com.bank.manager.dao.sys.RoleDao;
import com.bank.manager.domain.user.Role;
import com.bank.manager.service.sys.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl  implements RoleService {
    @Resource
    private RoleDao roleDao;

    @Override
    public List<Role> getRoleList() {
        return roleDao.getRoleList();
    }

    @Override
    public List<Role> getRoleAll() {
        return roleDao.getRoleAll();
    }

    @Override
    public Role getUserAccess(long id) {
        return roleDao.getUserAccess(id);
    }

    @Override
    public boolean updateRole(Role role) {
        role.setEditTime(new Date());
        long res =  roleDao.updateRole(role);
        return res >0;
    }

    @Override
    public boolean insertRole(Role role) {
        role.setCreateTime(new Date());
        long res = roleDao.insertRole(role);
        return res > 0;
    }

    @Override
    public boolean deleteRoles(List ids) {
        long res = roleDao.deleteRoles(ids);
        return  res > 0;
    }

    @Override
    public boolean checkRoleName(Role role) {
        long res = roleDao.checkRoleName(role);
        return  res > 0;
    }
}

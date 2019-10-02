package com.bank.manager.service.impl;


import com.bank.manager.common.UserToken;
import com.bank.manager.dao.UserDao;
import com.bank.manager.domain.sys.LdapUser;
import com.bank.manager.domain.user.User;
import com.bank.manager.mapper.LdapUserAttributeMapper;
import com.bank.manager.service.sys.UserService;
import com.bank.manager.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private LdapTemplate ldapTemplate;

    @Resource
    private UserDao userDao;

    @Override
    public boolean createLdapUser(LdapUser ldapUser) {
        ldapUser.setUserPassword(SecurityUtil.LdapEncoderMd5(ldapUser.getUserPassword()));
        try {
            ldapTemplate.create(ldapUser);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public LdapUser modifyLdapUser(LdapUser ldapUser) {
        ldapTemplate.update(ldapUser);
        return ldapUser;
    }

    @Override
    public void delLdapUser(LdapUser ldapUser) {
        ldapTemplate.delete(ldapUser);

    }

    @Override
    public List<LdapUser> getLdapUsers() {
        AndFilter filter = new AndFilter();
        filter.and(new EqualsFilter("objectClass", "person"));
        List users = ldapTemplate.search("ou=Users", filter.encode(), new LdapUserAttributeMapper());
        return users;
    }

    @Override
    public boolean authLdapUser(String username, String password) {
        AndFilter filter = new AndFilter();
        filter.and(new EqualsFilter("objectclass", "person")).and(new EqualsFilter("cn", username));
        return ldapTemplate.authenticate("", filter.toString(), password);
    }


    /**
     * user login admin 用户直接登陆系统 不去ldap验证
     *
     * @param userParam
     * @return
     */
    @Override
    public User login(User userParam) {
        User loginUser = userDao.login(userParam.getUserName());

        if (loginUser != null) {
            // 登陆成功,重置 token
            String token = UserToken.getToken();
            //当用户为admin的时候不去ldap验证
            System.out.println(loginUser.getUserName());
            if (loginUser.getId() == 1) {
                if (checkAdmin(userParam)) {
                    loginUser.setToken(token);
                    loginUser.setLoginTime(new Date());
                    userDao.updateUserToken(loginUser);
                    return loginUser;
                } else {
                    return null;
                }
            } else {
                if (authLdapUser(userParam.getUserName(), userParam.getPassword())) {
                    loginUser.setToken(token);
                    loginUser.setLoginTime(new Date());
                    userDao.updateUserToken(loginUser);
                    return loginUser;
                } else {
                    return null;
                }
            }
        }
        return null;
    }


    private boolean checkAdmin(User user) {
        user.setPassword(SecurityUtil.md5(user.getPassword()));
        int res = userDao.checkAdmin(user);
        return res == 1;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getUserList();
    }

    @Override
    public User findUserById(long id) {
        return userDao.findById(id);
    }

    @Override
    public boolean saveUser(User user) {
        user.setCreateTime(new Date());
        LdapUser ldapUser = setLdapUser(user);
        if (this.createLdapUser(ldapUser)) {
            user.setPassword(SecurityUtil.md5(user.getPassword()));
            long res = userDao.saveUser(user);
            if (res > 0){
                return true;
            }else{
                return false;
            }
        } else {
            delLdapUser(ldapUser);
            return false;
        }


    }

    @Override
    public long updateUser(User user) {
        String password = user.getPassword();

        if (password == null || password.isEmpty()) {
            user.setPassword(null);
        } else {
            LdapUser ldapUser = setLdapUser(user);
            modifyLdapUser(ldapUser);
            if (user.getUserName() == "admin") {
                user.setPassword(SecurityUtil.md5(password));
            }
            user.setPassword(null);
        }

        user.setEditTime(new Date());
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long[] userIds) {
        for (long id : userIds) {
            User user = userDao.findById(id);
            if (user != null) {
                System.out.println("userid" + id);
                LdapUser ldapUser = setLdapUser(user);
                delLdapUser(ldapUser);
                userDao.deleteUser(id);
            }
        }
    }

    @Override
    public boolean checkToken(long id, String token) {
        int num = userDao.findByToken(id, token);
        return num == 1;
    }

    @Override
    public boolean checkUserName(String userName) {
        int userNum = userDao.checkUserName(userName);
        System.out.println("checkUserName" + userNum);
        return userNum > 0;

    }

    private LdapUser setLdapUser(User user) {
        LdapUser ldapUser = new LdapUser();
        ldapUser.setCn(user.getUserName());
        ldapUser.setSn(user.getUserName());
        ldapUser.setUid(user.getUserName());
        ldapUser.setUserPassword(user.getPassword());
        return ldapUser;
    }

}
package com.bank.manager.service;

import com.bank.manager.domain.LdapUser;
import com.bank.manager.domain.User;

import java.util.List;

public interface UserService {

    boolean createLdapUser(LdapUser ldapUser);

    LdapUser modifyLdapUser(LdapUser ldapUser);

    void delLdapUser(LdapUser ldapUser);

    List<LdapUser> getLdapUsers();

    boolean authLdapUser(String username, String pass);

    User login(User user);


    /**
     * 获取用户信息列表
     *
     * @return
     */
    List<User> getAllUser();

    /**
     * 根据用户 ID,查询用户信息
     *
     * @param id
     * @return
     */
    User findUserById(long id);

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    void saveUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    long updateUser(User user);

    /**
     * 根据用户 ID,删除用户
     *
     * @param ids
     * @return
     */
    void deleteUser(Long[] ids);

    /**
     * 验证 token
     *
     * @param id 用户 ID
     * @param token 用户 token
     * @return true 通过;false 失败
     */
    boolean checkToken(long id, String token);


    boolean checkUserName(String userName);

}

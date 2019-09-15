package com.bank.manager.dao;

import com.bank.manager.domain.sys.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */

public interface UserDao {

    /**
     * 根据
     *
     * @param userName 用户名
     * @return 用户
     */
    User login(String userName);
    
    List<User> getUserList();
    
    User findById(@Param("id") long id);
    
    Long saveUser(User user);

    Long updateUser(User user);

    Long updateUserToken(User user);

    Long deleteUser(long id);

    int findByToken(long id, String token);

    int checkUserName(String userName);

}
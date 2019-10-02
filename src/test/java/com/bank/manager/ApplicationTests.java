package com.bank.manager;

import com.bank.manager.domain.user.User;
import com.bank.manager.service.sys.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Resource
    UserService userService;


//    @Resource
//    Person person;


    @Test
    public void check() throws Exception {
//        LdapUser ldapUser = new LdapUser();
//        ldapUser.setCn("benben17");
//        ldapUser.setSn("benben17");
//        ldapUser.setUid("benben17");
//
//        String password = SecurityUtil.LdapEncoderMd5("7654321");
//        ldapUser.setUserPassword(password);
//
//       List<Person> users =  userService.getAllUser();
//       for(Person user:users){
//           System.out.println(user.getCn());
//       }
//        userService.modifyPerson(ldapUser);
//        System.out.println(person.getCn());
//      List<LdapUser> users = userService.getAllUsers();
//      for(LdapUser person:users){
//          System.out.println(person.getCn()+person.getUid());
//      }
//    userService.deletePerson(ldapUser);
//        userService.create(ldapUser);
        User user = new User();
        user.setUserName("admin");
        user.setPassword("123456");
        User res = userService.login(user);
        System.out.println(res);
    }
}



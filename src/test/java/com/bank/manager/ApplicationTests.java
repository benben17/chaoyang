package com.bank.manager;

import com.bank.manager.domain.sys.LdapUser;
import com.bank.manager.service.UserService;
import com.bank.manager.utils.SecurityUtil;
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
    public void save() throws Exception {
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
        boolean res = userService.authLdapUser("benben17","7654321");
        System.out.println(res);
    }
}



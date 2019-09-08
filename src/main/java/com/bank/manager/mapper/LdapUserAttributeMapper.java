package com.bank.manager.mapper;

import com.bank.manager.domain.LdapUser;
import org.springframework.ldap.core.AttributesMapper;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

public class LdapUserAttributeMapper implements AttributesMapper {

    /**
     * 将单个Attributes转成单个对象
     *
     * @param attrs
     * @return
     * @throws NamingException
     */
    public Object mapFromAttributes(Attributes attrs) throws NamingException {
        LdapUser user = new LdapUser();


        if (attrs.get("cn") != null) {
            user.setCn(attrs.get("cn").get().toString());
        }
        if (attrs.get("sn") != null) {
            user.setCn(attrs.get("sn").get().toString());
        }
        if (attrs.get("uid") != null) {
            user.setUid(attrs.get("uid").get().toString());
        }
        if (attrs.get("mail") != null) {
            user.setEmail(attrs.get("email").get().toString());
        }

        return user;
    }
}
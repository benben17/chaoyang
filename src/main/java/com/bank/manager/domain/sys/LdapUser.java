package com.bank.manager.domain.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.ldap.odm.annotations.*;
import org.springframework.ldap.support.LdapNameBuilder;

import javax.naming.Name;


@Entry(objectClasses = {"inetOrgPerson", "person", "top", "organizationalPerson"}, base = "ou=users")
public class LdapUser {

    @Id
    @JsonIgnore
    private Name dn;

    @Attribute(name = "cn")
    private String cn;

    @Attribute(name = "sn")
    private String sn;
    @Attribute(name = "uid")
    private String uid;

    @Attribute(name = "userPassword")
    private String userPassword;
    @Attribute(name = "email")
    public String email;


    public LdapUser(String cn) {
        Name dn = LdapNameBuilder.newInstance()
                .add("ou", "users")
                .add("cn", cn)
                .build();
        this.dn = dn;
    }



    /* getter   */
    public Name getDn() {
        return dn;
    }

    public String getCn() {
        return cn;
    }

    public String getSn() {
        return sn;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserPassword() {
        return userPassword;
    }

    /* setter   */
    public void setDn(Name dn) {
        this.dn = dn;
    }

    public void setCn(String cn) {
        this.cn = cn;
        if (this.dn == null) {
            Name dn = LdapNameBuilder.newInstance()
                    .add("ou", "users")
                    .add("cn", cn)
                    .build();
            this.dn = dn;
        }
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "dn=" + dn.toString() +
                ", cn='" + cn + '\'' +
                ", sn='" + sn + '\'' +
                ", uid='" + uid + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    public LdapUser() {
    }

}


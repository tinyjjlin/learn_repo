package com.beruosi.oav1.entity;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;


@Entry(base = "ou=XX公司,dc=example,dc=com", objectClasses = {"OrganizationalPerson", "Person", "top"})
public class User {
    @Id
    private Name id;

    @DnAttribute(value = "distiguishedName")
    private String distinguishedName;

    @Attribute(name = "cn")
    private String commonName;

    @Attribute(name = "sn")
    private String suerName;

    @Attribute(name = "email")
    private String email;
}
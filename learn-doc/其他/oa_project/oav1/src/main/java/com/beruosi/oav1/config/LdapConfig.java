package com.beruosi.oav1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class LdapConfig {

    @Value("${ldap.url}")
    private String ldapUrl;

    @Value("${ldap.base}")
    private String ldapBase;

    @Value("${ldap.userDn}")
    private String ldapUserDn;

    @Value("${ldap.userPwd}")
    private String ldapUserPwd;

    @Value("${ldap.referral}")
    private String ldapReferral;


    private LdapTemplate ldapTemplate;

    /*
     * SpringLdap的javaConfig注入方式
     */
    @Bean
    public LdapTemplate ldapTemplate() {
        if(ldapTemplate==null){
            ldapTemplate = new LdapTemplate(contextSourceTarget());
        }
        return ldapTemplate;
    }

    /*
     * SpringLdap的javaConfig注入方式
     */
    @Bean
    public LdapContextSource contextSourceTarget() {
        LdapContextSource ldapContextSource = new LdapContextSource();

        ldapContextSource.setUrl(ldapUrl);
        ldapContextSource.setBase(ldapBase);
        ldapContextSource.setUserDn(ldapUserDn);
        ldapContextSource.setPassword(ldapUserPwd);
        ldapContextSource.setReferral(ldapReferral);


        return ldapContextSource;
    }

    public LdapContextSource contextSource (){
        LdapContextSource contextSource = new LdapContextSource();
        Map<String, Object> config = new HashMap();

        contextSource.setUrl(ldapUrl);
        contextSource.setBase(ldapBase);
        contextSource.setUserDn(ldapUserDn);
        contextSource.setPassword(ldapUserPwd);

        //  解决 乱码 的关键一句
        config.put("java.naming.ldap.attributes.binary", "objectGUID");

        contextSource.setPooled(true);
        contextSource.setBaseEnvironmentProperties(config);

        return contextSource;

    }
}

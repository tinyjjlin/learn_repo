package com.brs.oa.ad.repo;


import com.brs.oa.ad.entry.Person;
import com.brs.oa.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * @author tiny lin
 * @date 2018/12/21
 */
@Service
public class PersonRepo {
    @Autowired
    private LdapTemplate ldapTemplate;

    private class PersonAttributesMapper implements AttributesMapper<Person>{

        @Override
        public Person mapFromAttributes(Attributes attributes) throws NamingException {
            Person person  = new Person();
            person.setFullName(attributes.get("cn").get().toString());
            person.setDistinguishedName(attributes.get("distinguishedName").get().toString());
            person.setAccountName(attributes.get("sAMAccountName").get().toString());
            person.setEmpNo(CommonUtil.getEmpNo(person.getAccountName()));
            return person;
        }
    }

    private class PersonContextMapper  extends AbstractContextMapper<Person> {


        @Override
        protected Person doMapFromContext(DirContextOperations dirContextOperations) {
            Person person = new Person();
            person.setFullName(dirContextOperations.getStringAttribute("cn"));
            person.setDistinguishedName(dirContextOperations.getStringAttribute("distinguishedName"));
            person.setAccountName(dirContextOperations.getStringAttribute("sAMAccountName"));
            person.setDn(dirContextOperations.getDn());
            person.setReferralUrl(dirContextOperations.getReferralUrl());
            return person;
        }
    }

    //用户认证
    public boolean authenticate(String accountName,String password){
        Boolean result = false;
       try {
           ldapTemplate.authenticate(query().where("sAMAccountName").is(accountName), password);
           result = true;
       }catch (Exception e){
           System.out.println(e.getMessage());
           result = false;
       }
        return result;
    }

    //获取用户信息
    public Person getPersonInfo(String accountName){
       return  ldapTemplate.searchForObject(query().where("sAMAccountName").is(accountName), new PersonContextMapper() );
    }

    public List<String> getPersonNamesByName(String lastName) {
        LdapQuery query = query()
                .base("dc=brs,dc=dev")
                .attributes("cn", "sn")
                .where("objectclass").is("person")
                .and("cn").is(lastName);

        return ldapTemplate.search(query,
                new AttributesMapper<String>() {
                    @Override
                    public String mapFromAttributes(Attributes attrs)
                            throws NamingException {
                        return attrs.get("sn").get().toString();
                    }
                });
    }

    /**
     * 获取所有的用户账号信息
     * @return
     */
    public List<String> getAllAccount(){
        return ldapTemplate.search(query().where("objectclass").is("person"),
                new AttributesMapper<String>() {
                    @Override
                    public String mapFromAttributes(Attributes attributes) throws NamingException {
                        return attributes.get("sAMAccountName").get().toString();
                    }
                });
    }
    /**
     * 获取所有的用户
     * @return
     */
    public List <Person> getAllPerson(){
        return ldapTemplate.search(query().where("objectclass").is("person"),
                new PersonAttributesMapper());
    }

}

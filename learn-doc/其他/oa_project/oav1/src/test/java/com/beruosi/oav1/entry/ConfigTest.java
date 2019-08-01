//package com.beruosi.oav1.entry;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ldap.core.DirContextAdapter;
//import org.springframework.ldap.core.LdapTemplate;
//import org.springframework.ldap.filter.AndFilter;
//import org.springframework.ldap.filter.EqualsFilter;
//
//import java.util.List;
//
//public class ConfigTest extends BaseTest {
//    @Autowired
//    private LdapTemplate ldapTemplate;
//
//    /**
//     * 获取所有 内部人员
//     * ou=Internal,ou=People
//     */
//    @Test
//    public void listUsers() {
//        AndFilter filter = new AndFilter();
//        filter.and(new EqualsFilter("objectClass", "person"));
//
//        //查询所有内部人员
//        List<LdapUser> users = ldapTemplate.search("ou=Internal,ou=People", filter.encode(), new LdapUserAttributeMapper());
//        for (LdapUser user : users) {
//            System.out.println(user);
//        }
//
////        Assert.assertEquals(3056, users.size());
//    }
//
//    /**
//     * 根据uid 查找单个人员
//     */
//    @Test
//    public void findUser() {
//
//        //uid=00012047,ou=Internal,ou=People,o=cvte.com,o=isp
//        DirContextAdapter obj = (DirContextAdapter) ldapTemplate.lookup("uid=00012047,ou=Internal,ou=People");//BASE_DC 不用填
//        System.out.println(obj);
//    }
//
//    /**
//     * 根据部门编号o，查找部门
//     */
//    @Test
//    public void findDept() {
//        //o=598b09cb12ab4364864d8ac73ecee00d,ou=Organizations,ou=People,o=cvte.com,o=isp
//        DirContextAdapter obj = (DirContextAdapter) ldapTemplate.lookup("o=598b09cb12ab4364864d8ac73ecee00d,ou=Organizations");//BASE_DC 不用填
//        System.out.println(obj);
//    }
//
//    @Test
//    public void listDepts() {
//        AndFilter filter = new AndFilter();
//        filter.and(new EqualsFilter("objectClass", "organization"));
//        //search是根据过滤条件进行查询，第一个参数是父节点的dn，可以为空，不为空时查询效率更高
//        List depts = ldapTemplate.search("", filter.encode(), new LdapDeptAttributeMapper());
//        System.out.println(depts.size());
////        Assert.assertEquals(3056, depts.size());
//    }
//}
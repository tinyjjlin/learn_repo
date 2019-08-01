import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class ADDemo {

    /**
     * 使用java连接AD域
     * @author Herman.Xiong
     * @date 2014-12-23 下午02:24:04
     * @return void
     * @throws 异常说明
     * @param host 连接AD域服务器的ip
     * @param post AD域服务器的端口
     * @param username 用户名
     * @param password 密码
     */
    public static void connect(String host,String post,String username,String password) {
        DirContext ctx=null;
        Hashtable<string,string> HashEnv = new Hashtable<string,string>();
        HashEnv.put(Context.SECURITY_AUTHENTICATION, simple); // LDAP访问安全级别(none,simple,strong)
        HashEnv.put(Context.SECURITY_PRINCIPAL, username); //AD的用户名
        HashEnv.put(Context.SECURITY_CREDENTIALS, password); //AD的密码
        HashEnv.put(Context.INITIAL_CONTEXT_FACTORY,com.sun.jndi.ldap.LdapCtxFactory); // LDAP工厂类
        HashEnv.put(com.sun.jndi.ldap.connect.timeout, 3000);//连接超时设置为3秒
        HashEnv.put(Context.PROVIDER_URL, ldap:// + host + : + post);// 默认端口389
        try {
            ctx = new InitialDirContext(HashEnv);// 初始化上下文
            System.out.println(身份验证成功!);
        } catch (AuthenticationException e) {
            System.out.println(身份验证失败!);
            e.printStackTrace();
        } catch (javax.naming.CommunicationException e) {
            System.out.println(AD域连接失败!);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(身份验证未知异常!);
            e.printStackTrace();
        } finally{
            if(null!=ctx){
                try {
                    ctx.close();
                    ctx=null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        AdTest.connect(10.10.2.116, 389, herman@herman.com, 123456);
    }
}

## learn springboot 01 配置文件 
通过配置文件，可以在代码外部设置属性值。

## @ConfigurationProperties @Value 

reference: 

1. [SpringBoot | @Value 和 @ConfigurationProperties 的区别](https://www.jianshu.com/p/82fe2a00a124)
2. [Spring Boot 2.0 @ConfigurationProperties 使用](https://segmentfault.com/a/1190000016941757?utm_source=tag-newest)
3. [springboot系列三、springboot 单元测试、配置访问路径、多个配置文件和多环境配置，项目打包发布](https://www.cnblogs.com/wangzhuxing/p/10134617.html)

##

```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext_realm.xml",
                                    "classpath*:/applicationContext_daily.xml",
                                    "classpath*:/applicationContext.xml",
                                    "classpath*:/applicationContext_airwarm.xml",
                                    "classpath*:/applicationContext_airwet.xml",
                                    "classpath*:/applicationContext_illum.xml",
                                    "classpath*:/applicationContext_rainfall.xml"
                                })

public class testRealmEbo {
    @Autowired
    private RealmEbi realmEbi;
    @Autowired
    private SoilRealmAction soilRealmAction;

    @Test
    public void test1(){
        realmEbi.getLatestData(RealmApplianceModel.sendData1+RealmApplianceModel.service1);
//      String services = realmEbi.getAllServices();
//      System.out.println(services);
    }

    @Test
    public void test2(){
        realmEbi.insertDaily("check&!&admin&!&admin&!&select&!&rangedata&!&360702AA01&!&2018-01-07&!&2018-01-07&!&day");
    }
--------------------- 
作者：欧阳思海 
来源：CSDN 
原文：https://blog.csdn.net/sihai12345/article/details/79006199 
版权声明：本文为博主原创文章，转载请附上博文链接！
```
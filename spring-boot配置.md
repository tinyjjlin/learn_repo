# springboot 配置

## @ConfigurationProperties


## @PropertySource



##
```
     Enumeration<String> pa = request.getParameterNames();
        while(pa.hasMoreElements()){
            String item = pa.nextElement();
            log.info("request.........>"+ item);
        }


```

## 参考
1[Springboot中PropertySource注解的使用](https://blog.csdn.net/qq_30739519/article/details/78791142)


## filter 添加请求体信息

```
                 HashMap paramMap = new HashMap(request.getParameterMap());
                 paramMap.put("userId",new String[]{String.valueOf(userId)} );
                 ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper(request,paramMap );
                log.info("request userid.................>"+request.getParameter("userId"));
```

```
public class ParameterRequestWrapper extends HttpServletRequestWrapper {
    private Map params;

    public ParameterRequestWrapper(HttpServletRequest request, Map params) {
        super(request);
        this.params = params;
    }

    @Override
    public Map getParameterMap() {
        return params;
    }

    @Override
    public Enumeration getParameterNames() {
        Vector l = new Vector(params.keySet());
        return l.elements();
    }

    @Override
    public String[] getParameterValues(String name) {
        Object v = params.get(name);
        if (v == null) {
            return null;
        } else if (v instanceof String[]) {
            return (String[]) v;
        } else if (v instanceof String) {
            return new String[]{(String) v};
        } else {
            return new String[]{v.toString()};
        }
    }

    @Override
    public String getParameter(String name) {
        Object v = params.get(name);
        if (v == null) {
            return null;
        } else if (v instanceof String[]) {
            String[] strArr = (String[]) v;
            if (strArr.length > 0) {
                return strArr[0];
            } else {
                return null;
            }
        } else if (v instanceof String) {
            return (String) v;
        } else {
            return v.toString();
        }
    }
}


```

## filter 修改请求体中的参数
1. [使用HttpServletRequestWrapper重写Request请求参数的一点思考](https://blog.csdn.net/u014078904/article/details/82759376)
2. [SpringBoot拦截Request修改里面参数内容(HttpServletRequestWrapper)](https://blog.csdn.net/lightofsms/article/details/79819801)
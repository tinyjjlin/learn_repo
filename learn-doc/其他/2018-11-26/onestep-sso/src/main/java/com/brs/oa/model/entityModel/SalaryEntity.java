package com.brs.oa.model.entityModel;


import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;

public class SalaryEntity {
    public static final String[] TABLE_COLUMS={"userId","col_1","col_2","col_3","co_4"};
    public static final String[] FIELD_NAMES={"userId","col_1","col_2","col_3","co_4"};
    private Integer userId;
    private String col_1;
    private String col_2;
    private String col_3;
    private String col_4;

    private FieldInfo userIdF = new FieldInfo("userId","userId" , "Integer");


}

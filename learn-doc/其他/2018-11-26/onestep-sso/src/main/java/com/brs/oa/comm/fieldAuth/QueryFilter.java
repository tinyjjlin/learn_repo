package com.brs.oa.comm.fieldAuth;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface QueryFilter {
    String dtoName() default  "";
}

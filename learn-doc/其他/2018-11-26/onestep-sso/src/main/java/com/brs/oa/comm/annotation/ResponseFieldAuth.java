package com.brs.oa.comm.annotation;

import com.brs.oa.model.EntityType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseFieldAuth {
    EntityType type();
    Class entityClass();
}

package com.jinyuan.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @Author: Aaron
 * @Param:
 * @Description: 判断管理员是否登录
 *
 * @Date: 16:08 2020/6/1
 **/

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ManagerLogin {
    boolean required() default true;
}

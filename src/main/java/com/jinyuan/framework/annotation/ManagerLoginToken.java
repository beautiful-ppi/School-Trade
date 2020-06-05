package com.jinyuan.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @Author: Aaron
 * @Param:
 * @Description: 判断请求方法是否需要管理员的Token登录，默认为True
 *
 * @Date: 16:08 2020/6/1
 **/

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ManagerLoginToken {
    boolean required() default true;
}

package com.liutao.redis;

/**
 * @ClassName CanUpdate
 * @Descrption TODO
 * @Author lt
 * @Date 2019/2/24 16:09
 * @Version 1.0
 **/

import com.liutao.common.CacheValue;

import java.lang.annotation.*;

/**
 * 自定义注解，结合AOP实现Redis自动缓存
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface CanUpdate {
    CacheValue value();
}

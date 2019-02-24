package com.liutao.redis;

/**
 * @ClassName RedisCache
 * @Descrption TODO
 * @Author lt
 * @Date 2019/2/24 15:39
 * @Version 1.0
 **/

import java.lang.annotation.*;

/**
 * 自定义注解，结合AOP实现Redis自动缓存
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface RedisCache {
}
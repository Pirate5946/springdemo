package com.liutao.redis;

/**
 * @ClassName RedisCacheAspect
 * @Descrption TODO
 * @Author lt
 * @Date 2019/2/24 15:41
 * @Version 1.0
 **/

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RedisCacheAspect {

    @Autowired
    private RedisHelper redisHelper;
    @Autowired
    private RedisService redisService;

    @Pointcut("@annotation(com.liutao.redis.RedisCache)")
    public void setJoinPoint(){}

    //环绕通知:可以获取返回值
    @Around(value = "setJoinPoint()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        Object result = null;
        try {
            //前置通知

            result = proceedingJoinPoint.proceed();

            //返回通知
            Signature signature = proceedingJoinPoint.getSignature();
            String cacheString = redisService.get(signature.getName());
            if (cacheString == null) {
                //缓存至Redis
                Object[] args = proceedingJoinPoint.getArgs();
                //key策略：需要缓存的对象的全类名-id，如：entity.User-1
                redisService.set(signature.getName(),"20");
            }

        } catch (Throwable e) {
            //异常通知

        }
        //后置通知

        return result;
    }

}

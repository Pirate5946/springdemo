package com.liutao.redis;

/**
 * @ClassName CanUpdateAspect
 * @Descrption TODO
 * @Author lt
 * @Date 2019/2/24 16:10
 * @Version 1.0
 **/


import com.liutao.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CanUpdateAspect {

    @Autowired
    private RedisHelper redisHelper;
    @Autowired
    private RedisService redisService;

    @Pointcut("@annotation(com.liutao.redis.CanUpdate)")
    public void setJoinPoint(){}

    //环绕通知:可以获取返回值
    @Around(value = "setJoinPoint()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        Object result = null;
        try {
            //前置通知
            String cacheString = redisService.get("listUser");
            if (cacheString != null) {
                //缓存至Redis
                Object[] args = proceedingJoinPoint.getArgs();
                Signature signature = proceedingJoinPoint.getSignature();//此处joinPoint的实现类是MethodInvocationProceedingJoinPoint
                MethodSignature methodSignature = (MethodSignature) signature;//获取参数名
                CanUpdate canUpdate = methodSignature.getMethod().getAnnotation(CanUpdate.class);
                int oldValue = Integer.parseInt(canUpdate.value().getValue());
                System.out.println(oldValue);
                //key策略：需要缓存的对象的全类名-id，如：entity.User-1
                redisService.set(result.getClass().getName(), String.valueOf(oldValue++));
            }

            result = proceedingJoinPoint.proceed();

            //返回通知


        } catch (Throwable e) {
            //异常通知

        }
        //后置通知

        return result;
    }

}

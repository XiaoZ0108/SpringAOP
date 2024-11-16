package com.example.MyAOP.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAOP {

    private Logger logger= LoggerFactory.getLogger(getClass());

    //advice  //point cut =when to intercept method call
    //@Before("execution(* com.example.MyAOP.Data.*.*(..))")
    //specify certain method
    @Before("execution(* com.example.MyAOP.Service.MyService.dummyMethod(..))")
    public void beforeMethodCallAOP(JoinPoint joinPoint){
        logger.info("Before method called -{} with argument -{}",joinPoint,joinPoint.getArgs());
    }

    @After("execution(* com.example.MyAOP.Service.MyService.dummyMethod(..))")
    public void afterMethodCallAOP(JoinPoint joinPoint){
        logger.info("After method called -{}",joinPoint);
    }

    @AfterReturning(pointcut = "execution(* com.example.MyAOP.Service.MyService.dummyMethod(..))",returning ="result")
    public void afterReturningMethodCallAOP(JoinPoint joinPoint,Object result){
        logger.info("After returning method call -{} has return -{}",joinPoint,result );
    }


    @AfterThrowing(pointcut = "execution(* com.example.MyAOP.Service.MyService.throwErrorMethod(..))",throwing ="exception")
    public void afterThrowingMethodCallAOP(JoinPoint joinPoint,Exception exception){
        logger.info("After throwing method call -{} , has throwing -{}",joinPoint,exception.getMessage());
    }

}

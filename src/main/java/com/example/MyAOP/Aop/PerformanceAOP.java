package com.example.MyAOP.Aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceAOP {
    private Logger logger= LoggerFactory.getLogger(getClass());


    @Pointcut("@annotation(com.example.MyAOP.Annotations.TrackTime)")
    public void logTrackTime(){}


    //@Around("execution(* com.example.MyAOP.Service.MyService.dummyMethod2(..))")
    @Around("logTrackTime()")
    public Object performanceAOP(ProceedingJoinPoint proceedingJoinPoint){
        Object result=null;
        long startTime=System.currentTimeMillis();
        try{
            result=proceedingJoinPoint.proceed();
        }catch (Throwable e){
            logger.error("Error occurred while executing method: {}", proceedingJoinPoint.getSignature(), e);
        }


        long endTime=System.currentTimeMillis();
        long executionDuration=endTime-startTime;

        logger.info("Around performance aspect -{} and consume -{} millisecond",proceedingJoinPoint,executionDuration);
        return result;
    }
}

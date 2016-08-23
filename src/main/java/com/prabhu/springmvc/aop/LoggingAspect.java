package com.prabhu.springmvc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.prabhu.springmvc.annotation.LogDuration;

@Component
@Aspect
public class LoggingAspect {

    //for any method with @LogDuration, no matter what the return type, name, or arguments are, call this method 
	@Around("execution(@com.prabhu.springmvc.annotation.LogDuration * *(..)) && @annotation(logDurationAnnotation)")
    public Object logDuration(ProceedingJoinPoint joinPoint, LogDuration logDurationAnnotation) throws Throwable {
       
        //capture the start time 
        long startTime = System.currentTimeMillis();
        
        //execute the method and get the result
        Object result = joinPoint.proceed();
        
        //capture the end time
        long endTime = System.currentTimeMillis();
        
        //calculate the duration and print results
        long duration = endTime - startTime;
        System.out.println(logDurationAnnotation.value()+": "+duration+"ms"); //you should use a logger  
        
        //return the result to the caller
        return result; 
    }

}
package com.informatics.cscb869f2020week13.services.implementations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class LoggingServiceImplementation {

    @Before("execution(* SchoolServiceImpl.getSchools(..))")
    public void before(JoinPoint joinPoint) {
        System.out.print("Notification!!! Before ");
        System.out.print(joinPoint.getSignature().getName());
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }

    @Before("@annotation(com.informatics.cscb869f2020week13.services.Loggable)")
    public void beforeLoggable(){

        System.out.println("Executing Before Loggable!!");
    }

    @AfterReturning(pointcut = "execution(* SchoolServiceImpl.getSchool(..))",
            returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        System.out.print("After ");
        System.out.print(joinPoint.getSignature().getName());
        System.out.println("Notification!!! result is " + result);
    }
}

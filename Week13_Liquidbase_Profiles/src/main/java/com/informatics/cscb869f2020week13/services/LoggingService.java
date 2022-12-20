package com.informatics.cscb869f2020week13.services;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

public interface LoggingService {

    void before(JoinPoint joinPoint);

    void after(JoinPoint joinPoint, Object result);

    void around(ProceedingJoinPoint joinPoint);
}

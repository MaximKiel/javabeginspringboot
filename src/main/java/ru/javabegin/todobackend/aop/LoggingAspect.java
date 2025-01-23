package ru.javabegin.todobackend.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Log
public class LoggingAspect {

    @Around("execution(* ru.javabegin.todobackend.controller..*(..)))")
    public Object profileControllerMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        log.info("---------- Executing " + className + "." + methodName + " ----------");

        StopWatch count = new StopWatch();

        count.start();
        Object result = proceedingJoinPoint.proceed();
        count.stop();

        log.info("---------- Executing time of " + className + "." + methodName + " :: " + count.getTotalTimeSeconds() + " ----------");

        return result;
    }

}

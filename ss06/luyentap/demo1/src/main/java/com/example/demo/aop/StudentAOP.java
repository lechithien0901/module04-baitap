package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class StudentAOP {
@AfterThrowing(pointcut = "execution(* com.example.demo.controller.StudentController.*(..))",throwing = "e")
public void callList(JoinPoint joinPoint,Exception e){
    String clasname=joinPoint.getTarget().getClass().getSimpleName();
    String args = Arrays.toString(joinPoint.getArgs());
    String method = joinPoint.getSignature().getName();

    System.out.println(String.format("[CMS] co loi xay ra",clasname,args,method,e.getMessage()));
    System.out.println(String.format(clasname,args,e.getMessage()));


}
@AfterThrowing("execution(* com.example.demo.controller.StudentController.*(..))")
    public void log(){}


}

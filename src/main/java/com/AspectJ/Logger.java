package com.AspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import javax.ejb.Local;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Aspect
public class Logger {
    @AfterReturning(pointcut = "execution(* com.controllers.LoginController.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("before method: " + joinPoint.getSignature().getName());
        LocalDateTime myDateObj = LocalDateTime.now();

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);

        System.out.println("before method: " + formattedDate);
    }

}

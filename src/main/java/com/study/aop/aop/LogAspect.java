package com.study.aop.aop;

import com.study.aop.config.AuditoriaDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@RequiredArgsConstructor
@Component
public class LogAspect {
    private final AuditoriaDTO auditoria;
    @Before("execution(* com.example.demo.service.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        log.info("Entrou no método {}, {}", joinPoint.getSignature().getName(), auditoria);
    }
    @AfterReturning(value = "execution(* com.example.demo.service.*.*(..))", returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
        log.info("O método {} retornou {}",  joinPoint.getSignature().getName(), result);
    }
}

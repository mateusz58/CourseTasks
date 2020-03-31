package com.kodilla.patterns2.dao.calculator;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
@Aspect
public class Watcher {

    @Before("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))")
    public void logEvent() {
        log.info("Logging the event");
    }
}

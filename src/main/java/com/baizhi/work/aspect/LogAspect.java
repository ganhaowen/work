package com.baizhi.work.aspect;

import com.baizhi.work.controller.UserController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Pointcut(value = "execution(* com.baizhi.work.service.*.*(..))")
    void pt() {
    }

    @Pointcut(value = "@annotation(LogAun)")
    void pp() {
    }

    /*@Before(value = "pt()")
    void BeforeTest(){
        logger.error("前置增强");
    }*/

    @Around(value = "pp()")
    Object AroundTest(ProceedingJoinPoint proceedingJoinPoint) {
        logger.error("前置环绕增强");
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
            logger.error("后置环绕增强");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }


}

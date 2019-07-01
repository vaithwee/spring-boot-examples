package xyz.vaith.springbootaop.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import xyz.vaith.springbootaop.domain.User;
import xyz.vaith.springbootaop.validator.UserValidator;
import xyz.vaith.springbootaop.validator.impl.UserValidatorImpl;


@Aspect
@Log4j2
public class MyAop {

    @DeclareParents(value = "xyz.vaith.springbootaop.service.impl.IUserServiceImpl", defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

    @Pointcut("execution(* xyz.vaith.springbootaop.service.impl.IUserServiceImpl.printUser(..))")
    public void pointCut() {

    }

    /*
    @Before("pointCut()")
    public void before() {
        log.info("executing before method");
    }

     */

    @Before("pointCut() && args(user)")
    public void beforeWithParam(JoinPoint joinPoint, User user) {
        Object[] args = joinPoint.getArgs();
        log.info("executing before method");
    }

    @After("pointCut()")
    public void after() {
        log.info("executing after method");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        log.info("executing afterReturning method");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        log.info("executing afterThrowing method");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around before");
        joinPoint.proceed();
        log.info("around after");
    }


}

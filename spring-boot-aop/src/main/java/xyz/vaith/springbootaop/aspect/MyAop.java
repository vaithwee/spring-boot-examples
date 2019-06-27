package xyz.vaith.springbootaop.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.*;


@Aspect
@Log4j2
public class MyAop {

    @Pointcut("execution(* xyz.vaith.springbootaop.service.impl.IUserServiceImpl.printUser(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before() {
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
}

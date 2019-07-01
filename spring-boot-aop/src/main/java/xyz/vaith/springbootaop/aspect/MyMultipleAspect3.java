package xyz.vaith.springbootaop.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
@Log4j2
@Order(1)
public class MyMultipleAspect3 {
    @Pointcut("execution(* xyz.vaith.springbootaop.service.impl.IUserServiceImpl.multipleAspects(..))")
    public void pointCut()
    {

    }

    @Before("pointCut()")
    public void before() {
        log.info("multiple aspect before method " + this.getClass().getSimpleName());
    }


    @After("pointCut()")
    public void after() {
        log.info("multiple aspect after method " + this.getClass().getSimpleName());
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        log.info("multiple aspect afterReturning method " + this.getClass().getSimpleName());
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        log.info("multiple aspect afterThrowing method " + this.getClass().getSimpleName());
    }

}

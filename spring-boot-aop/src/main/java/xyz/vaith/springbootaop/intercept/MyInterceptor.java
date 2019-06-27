package xyz.vaith.springbootaop.intercept;

import lombok.extern.log4j.Log4j2;
import xyz.vaith.springbootaop.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

@Log4j2
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        log.info("executing before");
        return true;
    }

    @Override
    public boolean after() {
        log.info("executing after");
        return true;
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        log.info("executing around");
        Object object = invocation.proceed();
        return object;
    }

    @Override
    public void afterReturning() {
        log.info("executing after returning");
    }

    @Override
    public void afterThrowing() {
        log.info("executing after throwing");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}

package xyz.vaith.springbootaop.intercept;



import xyz.vaith.springbootaop.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {
    boolean before();
    boolean after();
    Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;
    void afterReturning();
    void afterThrowing();
    boolean useAround();
}

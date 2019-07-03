package xyz.vaith.springbootdatabase.plugin;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})

@Log4j2
public class MyPlugin implements Interceptor {

    Properties properties = null;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("plugin intercept method executed");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}

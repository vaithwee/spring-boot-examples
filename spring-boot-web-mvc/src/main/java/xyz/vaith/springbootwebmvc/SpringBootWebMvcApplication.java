package xyz.vaith.springbootwebmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import xyz.vaith.springbootwebmvc.interceptor.Interceptor1;

import java.util.Locale;

@SpringBootApplication
public class SpringBootWebMvcApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebMvcApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir = registry.addInterceptor(new Interceptor1());
        ir.addPathPatterns("/interceptor/*");
        registry.addInterceptor(localeChangeInterceptor());
    }

    private LocaleChangeInterceptor lci;
    @Bean(name = "localeResolver")
    public SessionLocaleResolver initLocalResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        if (lci != null) {
            return lci;
        }
        lci = new LocaleChangeInterceptor();
        lci.setParamName("language");
        return lci;
    }
}

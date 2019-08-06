package xyz.vaith.springbootthymeleaftemplate.annonation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface WebContent {
    String title() default "default title";
}

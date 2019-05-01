package org.spring.annotation;


import java.lang.annotation.*;

@Target(ElementType.TYPE)

@Retention(RetentionPolicy.RUNTIME)

@Repeatable(Filters.class)

public @interface Filter {

    String value();

}

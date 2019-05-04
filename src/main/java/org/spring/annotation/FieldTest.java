package org.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)

@Retention(RetentionPolicy.RUNTIME)

public @interface FieldTest {
    /**
     * 描述业务操作
     * @return
     */
    String type() default "";


}

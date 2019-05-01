package org.spring.aop;


import org.spring.annotation.Filter;

@Filter("/admin")

@Filter("/filter")

public class TestAnnotation {

    public static void main(String[] args) {

        Class<TestAnnotation> filterClassClass = TestAnnotation.class;

        Filter[] annotationsByType = filterClassClass.getAnnotationsByType(Filter.class);

        if (annotationsByType != null) {

            for (Filter filter : annotationsByType) {

                System.out.println(filter.value());

            }

        }

        System.out.println(filterClassClass.getAnnotation(Filter.class));

    }

}

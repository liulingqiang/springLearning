package org.spring.dynamic;

/**
 * Created by liulq on 2018-05-07 .
 */
public class RealSubject implements Subject {
    @Override
    public String getName() {
        System.out.println("--------------- getName -----");
        return "liu";
    }

    @Override
    public String getLast() {
        System.out.println("--------------- getLast -----");
        return "lingqiang";
    }
}

package org.spring.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by liulq on 2018-05-07 .
 */
public class SubjectInvocationHandler implements InvocationHandler {

    private Object sub;
    public SubjectInvocationHandler(Object obj) {
        sub = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        System.out.println("Proxy start...");
        System.out.println("method name:" + method.getName());
        result= method.invoke(sub, args);
        System.out.println("Proxy end...");
        return result;
    }
}

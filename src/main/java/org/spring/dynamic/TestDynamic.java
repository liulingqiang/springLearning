package org.spring.dynamic;

/**
 * Created by liulq on 2018-05-07 .
 */
public class TestDynamic {
    public static void main(String[] args) {
        BookFacadeCglib cglib=new BookFacadeCglib();
        BookFacadeImpl bookCglib=(BookFacadeImpl)cglib.getInstance(new BookFacadeImpl());
        bookCglib.addBook();

       /* RealSubject rs = new RealSubject(); // 在这里指定被代理类
        InvocationHandler ds = new SubjectInvocationHandler(rs);
        Class cls = rs.getClass();

        // 以下是一次性生成代理
        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(),ds );
        System.out.println("----------" + subject.getLast());*/
    }
}

package org.spring.test;

import org.springframework.stereotype.Component;

@Component("knight")
public class BraveKnight {
    public void saying(){
        System.out.println("我是骑士..（切点方法）");
    }
}

package org.activiti.rest.editor.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liulq on 2017-09-28 .
 */
@Controller
public class HelloWorld {


    @RequestMapping("/test")
    @ResponseBody
    public String getHelloWorld(){
        return "hello world";
    }

    @RequestMapping("/test1")
    @ResponseBody
    public String getHelloWorld1(){
        return "hello world1";
    }

}

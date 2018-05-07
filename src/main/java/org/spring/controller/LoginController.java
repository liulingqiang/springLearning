package org.spring.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.annotation.SystemControllerLog;
import org.spring.model.Acount;
import org.spring.service.BankAcount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 登入控制器
 *
 * @author liulq
 */
@Controller
@RequestMapping("/")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    BankAcount bankAcount;

    /**
     * 系统登入
     */
    @SystemControllerLog(description = "登入系统")
    @RequestMapping("/login")
    @ResponseBody
    public String login() throws Exception {

        logger.info("{} 登入系统成功!", "test");
        return "ok";
    }

    @RequestMapping("/transferMoney")
    @ResponseBody
    public String transferMoney(@RequestBody Acount acount) {
        String result = "ok";

        bankAcount.tranfer(acount);

        return result;
    }




}

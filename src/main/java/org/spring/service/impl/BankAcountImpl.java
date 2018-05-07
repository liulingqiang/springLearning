package org.spring.service.impl;

import org.spring.dao.TransactionDao;
import org.spring.model.Acount;
import org.spring.service.BankAcount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * Created by liulq on 2018-05-04 .
 */
@Service
public class BankAcountImpl implements BankAcount {
    @Autowired
    TransactionDao transactionDao;

    @Resource
    private PlatformTransactionManager txManager;

    @Override
    public void tranfer(Acount acount){
        //构造函数初始化TransactionTemplate
        TransactionTemplate template = new TransactionTemplate(txManager);
        template.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        //重写execute方法实现事务管理
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                transactionDao.rollOutMoney(acount);
                if(acount.getStatus() == 1){
                    System.out.println("-------  enter status ---------");
                    throw new NullPointerException("null!");
                }
                transactionDao.rollInMoney(acount);
            }}
        );

    }

    @Override
    public void tranfer1(Acount acount){
        //定义事务隔离级别，传播行为，
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        //事务状态类，通过PlatformTransactionManager的getTransaction方法根据事务定义获取；获取事务状态后，Spring根据传播行为来决定如何开启事务
        TransactionStatus status = txManager.getTransaction(def);

        try {
            transactionDao.rollOutMoney(acount);
            if(acount.getStatus() == 1){
                System.out.println("-------  enter status ---------");
                throw new NullPointerException("null!");
            }
            transactionDao.rollInMoney(acount);
            txManager.commit(status);  //提交status中绑定的事务
        } catch (NullPointerException e) {
            System.out.println("-------------" + e.getMessage());
            txManager.rollback(status);  //回滚
        }


    }
}

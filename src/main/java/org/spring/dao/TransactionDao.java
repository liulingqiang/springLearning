package org.spring.dao;

import org.spring.model.Acount;

/**
 * Created by liulq on 2018-05-04 .
 */

public interface TransactionDao {

    void rollInMoney(Acount acount);

    void rollOutMoney(Acount acount);
}

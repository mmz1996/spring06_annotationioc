package com.mmz.dao.impl;

import com.mmz.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @Classname AccountDaoImpl
 * @Description TODO
 * @Date 2020/5/7 21:36
 * @Created by mmz
 */
@Repository(value = "accountDao")
public class AccountDaoImpl implements AccountDao {
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}

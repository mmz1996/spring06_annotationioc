package com.mmz.service.impl;

import com.mmz.dao.AccountDao;
import com.mmz.dao.impl.AccountDaoImpl;
import com.mmz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Classname AccountServiceImpl
 * @Description 账户的业务层实现类
 * @Date 2020/5/7 21:34
 * @Created by mmz
 */
@Component(value = "accountService")
@Scope("singleton")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void saveAccount(){
        accountDao.saveAccount();
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化方法");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法");
    }
}

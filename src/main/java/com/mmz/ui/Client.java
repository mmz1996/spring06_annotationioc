package com.mmz.ui;

import com.mmz.dao.AccountDao;
import com.mmz.service.AccountService;
import com.mmz.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname Client
 * @Description 模拟表现层用于调用业务层
 * @Date 2020/5/7 21:37
 * @Created by mmz
 */
public class Client {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        AccountService accountService = (AccountService)applicationContext.getBean("accountService");
        accountService.saveAccount();
    }
}

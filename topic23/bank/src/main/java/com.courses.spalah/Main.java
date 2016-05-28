package com.courses.spalah;

import com.courses.spalah.service.BankApplication;
import com.courses.spalah.view.MainFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

/**
 * Created by Leonid on 21.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        MainFrame  appFrame = new MainFrame();
        appFrame.start();
ApplicationContext context = new ClassPathXmlApplicationContext("bank-app-context.xml");
        BankApplication bank  = context.getBean("bankApp", BankApplication.class);
        bank.getAllClients();
    }
}

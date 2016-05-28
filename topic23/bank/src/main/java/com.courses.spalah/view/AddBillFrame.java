package com.courses.spalah.view;

import com.courses.spalah.model.Client;
import com.courses.spalah.service.BankApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

/**
 * Created by Leonid on 23.05.2016.
 */
public class AddBillFrame extends JFrame {
//    public  JPanel panel ;
//    public  JTextField txtInn ;
//    public AddBillFrame() {
//        super("Панель добавления Счета");
//        this.setSize(500, 400);
////        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);
//
//        init();
//        this.setLayout(new GridBagLayout());
//        this.setVisible(true);
//    }
//
//    private void init() {
//         panel = new JPanel();
//        JLabel lblInn = new JLabel("Введите Инн клиента");
//        panel.add(lblInn);
//
//        txtInn = new JTextField();
//        panel.add(txtInn);
//
//        JButton btnFindClient = new JButton("Найти клиента");
//        btnFindClient.addActionListener(new BtnFindClientActionListener());
//        panel.add(btnFindClient);
//    }
//
//    public class BtnFindClientActionListener implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//            Client client = BankApplication.findClient(Long.parseLong(txtInn.getText()));
//
//            panel.add(new JLabel("Баланс"));
//            JTextField txtBalance = new JTextField("100");
//            panel.add(txtBalance);
//            try {
//                BankApplication.addBill(client, new BigDecimal(txtBalance.getText()));
//                JOptionPane.showMessageDialog(null, null, "Счет успешно добавлен", JOptionPane.OK_OPTION);
//            }
//            catch (Exception ex)
//            {
//                JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка при добавлении счета", JOptionPane.OK_OPTION);
//            }
//        }
//    }
}

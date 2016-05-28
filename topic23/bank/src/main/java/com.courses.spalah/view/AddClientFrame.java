package com.courses.spalah.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.courses.spalah.service.BankApplication;

/**
 * Created by Leonid on 22.05.2016.
 */
public class AddClientFrame extends JFrame {
//    JTextField txtInn;
//    JTextField txtFirstName;
//    JTextField txtLastName;
//
//    AddClientFrame() {
//        super("Добавление Клиента");
//        this.setSize(500, 400);
////        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);
//        init();
//        this.setLayout(new GridBagLayout());
//        this.setVisible(true);
//    }
//
//    private void init() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//        JLabel lblInn = new JLabel("ИНН");
//        panel.add(lblInn);
//        txtInn = new JTextField("7777777777");
//        txtInn.setColumns(10);
//        panel.add(txtInn);
//
//        JLabel lblFName = new JLabel("Имя");
//        panel.add(lblFName);
//
//        txtFirstName = new JTextField("Иван");
//        panel.add(txtFirstName);
//
//        JLabel lblLName = new JLabel("Фамилия");
//        panel.add(lblLName);
//
//        txtLastName = new JTextField("Грозный");
//        panel.add(txtLastName);
//
//
//        JButton btnOk = new JButton("OK");
//        btnOk.addActionListener(new BtnOktActionListener());
//        panel.add(btnOk);
//
//        this.add(panel);
//    }
//
//    public class BtnOktActionListener implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//            String fName = txtFirstName.getText();
//            String lName = txtLastName.getText();
//            String inn = txtInn.getText();
//            try {
//                BankApplication.addClient(fName, lName, inn);
//                JOptionPane.showMessageDialog(null, null, "Клиент успешно добавлен", JOptionPane.OK_OPTION);
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка при добавлении клиента", JOptionPane.OK_OPTION);
//            }
//
//        }
//    }
}

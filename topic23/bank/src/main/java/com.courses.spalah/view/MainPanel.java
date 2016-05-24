package com.courses.spalah.view;

import com.courses.spalah.model.Bill;
import com.courses.spalah.model.Client;
import com.courses.spalah.service.BankApplication;
import org.hibernate.jpa.event.internal.core.JpaAutoFlushEventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Leonid on 21.05.2016.
 */
public class MainPanel extends JPanel {

    public MainPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        init();
    }

    private void init() {
        JButton btnAddClient = new JButton("Добавить клиента");
        btnAddClient.addActionListener(new BtnAddClientActionListener());
        this.add(btnAddClient);
        JButton btnFindClient = new JButton("Найти клиента");
        this.add(btnFindClient);
        JButton btnAddBill = new JButton("Добавить счет");
        this.add(btnAddBill);

        JButton btnShowAllClient = new JButton("Посмотреть всех клиентов");
        btnShowAllClient.addActionListener(new BtnShowAllClients());
        this.add(btnShowAllClient);

        JButton btnShowAllBills = new JButton("Посмотреть все счета");
        btnShowAllBills.addActionListener(new BtnShowAllBills());
        this.add(btnShowAllBills);

        JButton btnSendToBank = new JButton("Переслать деньги в другой банк");
        this.add(btnAddClient);
        JButton btnSendToClient = new JButton("Переслать деньги между клиентами банка");
        this.add(btnSendToClient);
        JButton btnShowBillTransactions = new JButton("Посмотреть все транзакции по СЧЕТУ");
        this.add(btnShowBillTransactions);
        JButton btnShowClientTransactions = new JButton("Посмотреть все транзакции КЛИНТА");
        this.add(btnShowClientTransactions);
    }

    public class BtnAddClientActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AddClientFrame frame = new AddClientFrame();
        }
    }

    public class BtnShowAllClients implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JFrame clFrame = new JFrame("Все клиенты");

            clFrame.setSize(500, 400);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            clFrame.setLocationRelativeTo(null);
            clFrame.setLayout(new GridBagLayout());
            clFrame.setVisible(true);

            JPanel panel = new JPanel();
            clFrame.add(panel);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            ArrayList<Client> clients = (ArrayList<Client>) BankApplication.getAllClients();
            for (Client cl : clients) {
                panel.add(new JTextArea(cl.getFirstName() + " " + cl.getLastName() + "    ИНН: " + cl.getInn()));
            }
        }
    }

    public class BtnShowAllBills implements ActionListener {
        JPanel panel;
StringBuffer sb;
        public void actionPerformed(ActionEvent e) {
            JFrame clFrame = new JFrame("Все счета");

            clFrame.setSize(500, 400);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            clFrame.setLocationRelativeTo(null);
            clFrame.setLayout(new GridBagLayout());
            clFrame.setVisible(true);

            panel = new JPanel();
            clFrame.add(panel);
            panel.add(new JLabel("Введите ИНН клиента"));
            final JTextField txtInn = new JTextField();
            txtInn.setColumns(15);
            panel.add(txtInn);


            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            JButton btnShow = new JButton("Найти");
            btnShow.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Client client = BankApplication.findClient(Long.parseLong(txtInn.getText()));
                    ArrayList<Bill> bills = (ArrayList<Bill>) BankApplication.getAllBill(client);
                    sb = new StringBuffer();
                    sb.append("Клиент: " + client.getFirstName() + " " + client.getLastName() );
                    for (Bill cl: bills)
                    {
                        sb.append("# "+ cl.getBillNumber() + " ballance = " + cl.getBalance() + "\n");
                        System.out.println(cl.toString());
                    }
                    panel.add(new JLabel("dfsdfsfsf"));
                }
            });

            panel.add(btnShow);



        }
    }
}



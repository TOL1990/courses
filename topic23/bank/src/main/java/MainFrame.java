import com.courses.spalah.service.BankApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Leonid on 18.05.2016.
 */
public class MainFrame extends JFrame {
    private JTextField textField;
    private JTextField firstField;
    private JTextField secondField;
    private JTextField thirdField;
    private JLabel outLable;


    public MainFrame() {
        super("Да неубоитесь Вы гамнокода написанного на скорую руку, да на Свинге!");
        createGUI();

    }

    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Button 1");
        button1.setActionCommand("Button 1 was pressed!");
        panel.add(button1);

        JButton btnCreateNewClient = new JButton("Create new Client");
        button1.setActionCommand("Button 1 was pressed!");
        panel.add(btnCreateNewClient);


        JButton button3 = new JButton("Button 3");
        button3.setActionCommand("Button 3 was pressed!");
        panel.add(button3);

        textField = new JTextField();
        textField.setColumns(23);
        panel.add(textField);
        firstField = new JTextField();
        firstField.setColumns(23);
        panel.add(firstField);
        secondField = new JTextField();
        secondField.setColumns(23);
        panel.add(secondField);
        thirdField = new JTextField();
        thirdField.setColumns(23);
        panel.add(thirdField);
        outLable = new JLabel("Вывод на экран");
        outLable.setVisible(true);
        panel.add(outLable);

        ActionListener actionListener = new TestActionListener();

        button1.addActionListener(actionListener);
//////////////////////////////////////////////////////////////////
        btnCreateNewClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = firstField.getText();
                String surname = firstField.getText();
                String inn = firstField.getText();
                BankApplication.addClient(name,surname, inn);
                textField.setText("Новый клиент добавлен");
            }
        });
        ///////////////////////////////////////
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                textField.setText(e.getActionCommand());
            }
        });
        //////////////////////////////////////
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                textField.setText(e.getActionCommand());
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                textField.setText(e.getActionCommand());
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                textField.setText(e.getActionCommand());
            }
        });

        getContentPane().add(panel);
        setPreferredSize(new Dimension(320, 100));
    }

    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            textField.setText(e.getActionCommand());
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                MainFrame frame = new MainFrame();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}


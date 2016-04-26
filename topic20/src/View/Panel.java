package View;

import SorterApp.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Leonid on 26.04.2016.
 */
public class Panel extends JPanel{
    private JTextField bubleField;
    private JTextField quickField;
    private JButton btnGenArr ;
    private JButton start ;
    private JButton pause ;
    private JButton stop ;
    private Controller controller;

Panel()
{
    this.setLayout(new FlowLayout());
    init();
}

    private void init() {
        controller = new Controller();

        btnGenArr = new JButton("Сгенерить массив");
        btnGenArr.setActionCommand("btnGenArr was pressed");
        this.add(btnGenArr);

//        btnGenArr = new JButton("Сгенерить массив");
//        btnGenArr.setActionCommand("btnGenArr was pressed");
//        this.add(start);
//
//        btnGenArr = new JButton("Сгенерить массив");
//        btnGenArr.setActionCommand("btnGenArr was pressed");
//        this.add(pause);
//
//        btnGenArr = new JButton("Сгенерить массив");
//        btnGenArr.setActionCommand("btnGenArr was pressed");
//        this.add(stop);

        bubleField = new JTextField();
        bubleField.setColumns(23);
        this.add(bubleField);

        btnGenArr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.generateArr();
                bubleField.setText(controller.getBubleArrStr());
            }
        });

    }
}

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
    private JButton btnStart ;
    private JButton btnPause ;
    private JButton btnStop ;
    private Controller controller;

Panel()
{
//    this.setLayout(new FlowLayout());
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    init();
}

    private void init() {
        controller = new Controller();

        bubleField = new JTextField();
        bubleField.setColumns(120);
        this.add(bubleField);

        quickField = new JTextField();
        quickField.setColumns(120);
        this.add(quickField);

        btnGenArr = new JButton("Сгенерить массив");
        btnGenArr.setActionCommand("btnGenArr was pressed");
        btnGenArr.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(btnGenArr);

        btnStart = new JButton("Старт");
        btnStart.setActionCommand("btnGenArr was pressed");
        this.add(btnStart);

        btnPause = new JButton("Пауза");
        btnPause.setActionCommand("btnGenArr was pressed");
        this.add(btnPause);

        btnStop = new JButton("Стоп");
        btnStop.setActionCommand("btnGenArr was pressed");
        this.add(btnStop);




        btnGenArr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.generateArr();
                bubleField.setText(controller.getBubleArrStr());
                quickField.setText(controller.getQuickArrStr());
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.start();
            }
        });
        btnPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.pause();
            }
        });

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        bubleField.setText(controller.getAlgorithms().get(1).outPrintStr());//1- buble alg
        quickField.setText(controller.getAlgorithms().get(2).outPrintStr());//2- quick alg

    }
    public void paintAlgs() throws InterruptedException {
        new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }).start();
    }
}

package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Leonid on 26.04.2016.
 */
public class MainFrame extends JFrame {
    public MainFrame()
    {
        super("Algorithms speed test");
        init();
    }
    public void init() {
        //Лучше заиметь 2 панели одну под вывод другую под кнопки
        Panel panel = new Panel();
        try {
            panel.paintAlgs();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.setContentPane(panel);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(1200, 600);
        this.setVisible(true);

        Thread mainTh = new Thread();
             mainTh.start();

        ///он должен имметь ссілки на панели
        // и постоянно перерисовівать с периодисчностью 60 млс.



    }
}

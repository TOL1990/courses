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
        Panel panel = new Panel();

        this.setContentPane(panel);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(1200, 600);
        this.setVisible(true);



    }
}

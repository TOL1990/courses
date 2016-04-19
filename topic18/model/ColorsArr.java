package model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Leonid on 17.04.2016.
 */
public class ColorsArr {
    private  ArrayList<Color> COLOR_LIST ;

    public  ColorsArr() {
        COLOR_LIST.add(Color.BLACK);
        COLOR_LIST.add(Color.BLUE);
        COLOR_LIST.add(Color.CYAN);
        COLOR_LIST.add(Color.GREEN);
        COLOR_LIST.add(Color.RED);
        COLOR_LIST.add(Color.MAGENTA);
        COLOR_LIST.add(Color.ORANGE);
        COLOR_LIST.add(Color.GRAY);
    }

    protected ArrayList<Color> getColorList() {
        return COLOR_LIST;
    }

    protected void setColorList(ArrayList<Color> colorList) {
        COLOR_LIST = colorList;
    }
}

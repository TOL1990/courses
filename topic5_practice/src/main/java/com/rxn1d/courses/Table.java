package com.rxn1d.courses;

/**
 * Created by Леонид on 24.02.2016.
 */
public class Table {
    RouleteRing ring;
    Player player; // расширить до многих игроков ввести места сидячие

    public Table() {
        ring = new RouleteRing();
        player = new Player();
    }
    public void run()
    {

    }
}

package ej.blocks;

import ej.exceptions.IllegalBlockException;

public class Wall extends Block {


    private boolean loadBearing;

    public Wall(final int length, final int width, final int height, final boolean loadBearing)
            throws IllegalBlockException {
        super(length, width, height);
        this.loadBearing = loadBearing;
        this.color = Color.GREY;
    }

    public boolean isTraversable() {
        return !loadBearing;
    }

}

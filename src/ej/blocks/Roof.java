package ej.blocks;

import ej.exceptions.IllegalBlockException;

public class Roof extends Block {

    public Roof(final int length, final int width, final int height) throws IllegalBlockException {
        super(length,width,height,Color.BROWN);
    }

}

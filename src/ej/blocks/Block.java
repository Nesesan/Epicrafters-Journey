package ej.blocks;

import ej.exceptions.IllegalBlockException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Block implements IBlock {

    Logger logger = LogManager.getLogger(Block.class);

    protected int length;
    protected int width;
    protected int height;
    protected Color color;

    public Block(final int length, final int width, final int height, final Color color)
            throws IllegalBlockException {
        if (length < MIN_LENGTH || width < MIN_WIDTH || height < MIN_HEIGHT) {
            logger.error("The minimum values for length, width, and height have not been met");
            throw new IllegalBlockException();
        }
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;

        logger.info("A block of type " + this.getClass().getSimpleName() + " has been constructed.");
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

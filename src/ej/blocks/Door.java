package ej.blocks;

import ej.exceptions.IllegalBlockException;
import ej.exceptions.LockedDoorException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Door extends Block {

    Logger logger = LogManager.getLogger(Door.class);
    private boolean locked;

    public Door(final int length, final int width, final int height, final boolean locked)
            throws IllegalBlockException {
        super(length, width, height,Color.BLUE);
        this.locked = locked;
    }

    public boolean isLocked() {
        return locked;
    }

    public void lock() throws LockedDoorException {
        if (!locked) {
            locked = true;
        } else {
            logger.error("Door is already locked");
            throw new LockedDoorException();
        }
    }
}

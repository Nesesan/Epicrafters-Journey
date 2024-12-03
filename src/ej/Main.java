package ej;

import ej.blocks.Door;
import ej.exceptions.IllegalBlockException;
import ej.exceptions.LockedDoorException;

public class Main {
    public static void main(String[] args) {
        try {
            Door door = new Door(1,1,1,true);
            door.lock();
        }catch (IllegalBlockException e){
            System.out.println("Unable to build the block");
        }catch (LockedDoorException e){
            System.out.println("The door is already locked");
        }
    }
}
package ej;

public class Door  extends Block{

    private boolean locked;

    public Door(final int length, final int width, final int height, final boolean locked) {
        super(length, width, height);
        this.locked = locked;
        this.color = Color.BLUE;
    }

    public boolean isLocked() {
        return locked;
    }
}

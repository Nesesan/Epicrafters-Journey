package ej;

public class Wall extends Block {

    private boolean loadBearing;

    public Wall(final int length, final int width, final int height, final boolean loadBearing) {
        super(length, width, height);
        this.loadBearing = loadBearing;
        this.color = Color.GREY;
    }

    public boolean isTraversable() {
        return !loadBearing;
    }

}

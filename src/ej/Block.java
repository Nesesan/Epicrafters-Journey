package ej;

public abstract class Block implements IBlock {

    protected int length;
    protected int width;
    protected int height;
    protected Color color;

    public Block(final int length, final int width, final int height) {
        this.length = length;
        this.width = width;
        this.height = height;
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

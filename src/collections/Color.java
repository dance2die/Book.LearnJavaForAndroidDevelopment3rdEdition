package collections;

public enum Color {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255);

    private int r, g, b;

    Color(int r, int g, int b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public String toString()
    {
        return String.format("r = %d, g = %d, b = %d", r, g, b);
    }
}

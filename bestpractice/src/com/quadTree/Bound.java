package com.quadTree;

public class Bound {
    private Point lower;
    private Point upper;

    public Bound(final Point lower, final Point upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public Bound(final int lx, final int ly, final int ux, final int uy) {
        this(new Point(lx, ly), new Point(ux, uy));
    }

    public Point getLower() {
        return lower;
    }

    public void setLower(final Point lower) {
        this.lower = lower;
    }

    public Point getUpper() {
        return upper;
    }

    public void setUpper(final Point upper) {
        this.upper = upper;
    }

    public boolean inRange(Point point) {
        if ((point.getX() >= lower.getX() && point.getX() <= upper.getX()) || point.getY() >= lower.getY() && point.getY() <= upper.getY())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Bound{" +
                "lower=" + lower +
                ", upper=" + upper +
                '}';
    }
}

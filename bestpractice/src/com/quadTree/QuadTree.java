package com.quadTree;

import java.util.ArrayList;
import java.util.List;

public class QuadTree {
    private QuadTree uleft;
    private QuadTree uright;
    private QuadTree lleft;
    private QuadTree lright;
    private int capacity;
    private Bound bounds;
    private List<Point> points;
    private int count;


    public QuadTree(int x, int y, int capacity) {
        this(0, 0, x, y);
        this.capacity = capacity;
    }

    public QuadTree(final int lx, final int ly, final int ux, final int uy) {
        bounds = new Bound(lx, ly, ux, uy);
    }

    public boolean insert(int x, int y) {
        Point point = new Point(x, y);
        if (!bounds.inRange(point))
            return false;
        boolean isInsert = false;
        if (count < capacity)
            isInsert = points.add(point);
        else {
            subDivide();
            isInsert = this.uleft.insert(x, y) ||
                    this.uright.insert(x, y) ||
                    this.lleft.insert(x, y) ||
                    this.lright.insert(x, y);
        }

        count++;
        return isInsert;
    }

    public List<Point> query(int lx, int ly, int ux, int uy) {
        Bound bound = new Bound(lx, ly, ux, uy);
        return query(bound);
    }

    private List<Point> query(Bound bound) {
        if (!intersect(bound))
            return null;
        List<Point> points = new ArrayList<Point>();
        for (Point point : points) {
            if (bound.inRange(point))
                points.add(point);
        }
        if (uleft != null) {
            points.addAll(uleft.query(bound));
            points.addAll(uright.query(bound));
            points.addAll(lleft.query(bound));
            points.addAll(lright.query(bound));

            uleft = uleft.uleft;
            uright = uright.uright;
            lleft = lleft.lleft;
            lright = lright.lright;
        }

        return points;
    }

    private boolean intersect(Bound bounds) {
        int rec1xl = bounds.getLower().getX();
        int rec1yl = bounds.getLower().getY();
        int rec1xu = bounds.getLower().getX();
        int rec1yu = bounds.getLower().getY();

        int rec2xl = this.bounds.getLower().getX();
        int rec2yl = this.bounds.getLower().getY();
        int rec2xu = this.bounds.getLower().getX();
        int rec2yu = this.bounds.getLower().getY();

        int recWidth = Math.min(rec1xu, rec2xu) - Math.max(rec1xl, rec2xl);
        int recLength = Math.min(rec1yu, rec2yu) - Math.max(rec1yl, rec2yl);

        if (recWidth <= 0 || recLength <= 0)
            return false;

        return true;
    }

    private void subDivide() {
        uleft = new QuadTree(bounds.getLower().getX(),
                (bounds.getLower().getY() + bounds.getUpper().getY()) / 2,
                (bounds.getLower().getX() + bounds.getUpper().getX()) / 2,
                bounds.getUpper().getY());
        uright = new QuadTree((bounds.getLower().getX() + bounds.getUpper().getX()) / 2,
                (bounds.getLower().getY() + bounds.getUpper().getY()) / 2,
                bounds.getUpper().getX(), bounds.getUpper().getY());
        lleft = new QuadTree(bounds.getLower().getX(), bounds.getLower().getY(),
                bounds.getLower().getX() + bounds.getUpper().getX() / 2,
                (bounds.getLower().getY() + bounds.getUpper().getY()) / 2);
        lright = new QuadTree((bounds.getLower().getX() + bounds.getUpper().getX()) / 2,
                bounds.getLower().getY(),
                bounds.getUpper().getX(),
                (bounds.getLower().getY() + bounds.getUpper().getY()) / 2);
    }

    @Override
    public String toString() {
        return "QuadTree{" +
                "uleft=" + uleft +
                ", uright=" + uright +
                ", lleft=" + lleft +
                ", lright=" + lright +
                ", capacity=" + capacity +
                ", bounds=" + bounds +
                '}';
    }
}

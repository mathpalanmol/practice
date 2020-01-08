package com.bestpractice.range;

public class Range {
    private int val;
    private int uppper;

    public Range(int val, int upper) {
        this.val = val;
        this.uppper = upper;
    }

    public int getVal() {
        return val;
    }

    public void setVal(final int val) {
        this.val = val;
    }

    public int getUppper() {
        return uppper;
    }

    public void setUppper(final int uppper) {
        this.uppper = uppper;
    }

    @Override
    public String toString() {
        return "Range{" +
                "lower=" + val +
                ", uppper=" + uppper +
                '}';
    }
}

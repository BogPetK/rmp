package com.company.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage
        extends House {

    private final boolean mSecondFloor;

    public Cottage(int dimension, int getlength, int getwidth) {
        super(dimension, getlength, getwidth, dimension);
        mSecondFloor = false;
    }

    public Cottage(int dimension, int getlength, int lotWidth, String owner, boolean secondFloor) {
        super(dimension, getlength, lotWidth, dimension, owner);
        mSecondFloor = secondFloor;
    }

    public boolean hasSecondFloor() {
        return mSecondFloor;
    }

    @Override
    public String toString() {
        String result = super.toString();

        if (hasSecondFloor()) {
            result += "; has a second floor.";
        }
        return result;
    }

}


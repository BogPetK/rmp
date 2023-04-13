package com.company.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    public static final int CLOSED = 0;
    public static final int IN = 1;
    public static final int OUT = -1;

    private int state;

    public Gate() {
        close();
    }

    public boolean setSwing(int direction) {
        if (direction == IN || direction == OUT || direction == CLOSED) {
            state = direction;
            return true;
        }
        return false;
    }

    public boolean open(int direction) {
        if (state == CLOSED && (direction == IN || direction == OUT)) {
            state = direction;
            return true;
        }
        return false;
    }

    public void close() {
        state = CLOSED;
    }

    public int getSwingDirection() {
        return state;
    }

    public int thru(int count) {
        switch (state) {
            case IN:
                return count;
            case OUT:
                return -count;
            default:
                return 0;
        }
    }

    public String toString() {
        switch (state) {
            case IN:
                return "This gate is open and swings to enter the pen only";
            case OUT:
                return "This gate is open and swings to exit the pen only";
            default:
                return "This gate is closed";
        }
    }
}
package com.psujek.utility;

public class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position fromPos(int position, int columns) {
        int x = (int) Math.ceil(position / (float) columns);
        int y = position - ((x - 1) * columns);
        return new Position(x, y);
    }

    public boolean isInvalid() {
        return x == -1 || y == -1;
    }
}

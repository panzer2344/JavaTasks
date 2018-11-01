package com.podval;

import java.util.Objects;

public class MyPoint {
    private int x = 0;
    private int y = 0;

    public MyPoint() {
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY(){
        int[] XY = new int[]{this.x, this.y};
        return XY;
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ',' + y + ')';
    }

    //distance to (x, y)
    public double distance(int x, int y){
        return Math.sqrt( Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2) );
    }

    //distance to another point
    public double distance(MyPoint point){
        return Math.sqrt( Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2) );
    }

    // distance to (0, 0)
    public double distance(){
        return Math.sqrt( x * x + y * y );
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        MyPoint point = (MyPoint) obj;

        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
}

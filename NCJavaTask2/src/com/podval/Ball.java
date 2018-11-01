package com.podval;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        double _direction = Math.PI * (double)direction / 180.0;
        this.xDelta = (float)(speed * Math.cos(_direction));
        this.yDelta = (float)(speed * Math.sin(_direction));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getxDelta() {
        return xDelta;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getyDelta() {
        return yDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move(){
        this.x += this.xDelta;
        this.y += this.yDelta;
    }

    public void reflectHorizontal(){
        this.xDelta = -this.xDelta;
    }

    public void reflectVertical(){
        this.yDelta = -this.yDelta;
    }

    @Override
    public String toString() {
        return "Ball[" + '(' + x + ',' + y + "), speed=(" + xDelta + "," + yDelta + ")]";
    }


    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Ball container = (Ball) obj;

        return this.x == container.x && this.y == container.y && this.radius == container.radius &&
                this.xDelta == container.xDelta && this.yDelta == container.yDelta;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Float.floatToIntBits(this.x);
        result = 31 * result + Float.floatToIntBits(this.y);
        result = 31 * result + Float.floatToIntBits(this.xDelta);
        result = 31 * result + Float.floatToIntBits(this.yDelta);
        result = 31 * result + radius;

        return result;
    }
}

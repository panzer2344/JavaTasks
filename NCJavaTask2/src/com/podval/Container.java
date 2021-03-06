package com.podval;

import com.podval.Ball;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width;
        this.y2 = y + height;
    }

    public int getX(){
        return this.x1;
    }

    public int getY(){
        return this.y1;
    }

    public int getWidth(){
        return this.x2 - this.x1;
    }

    public int getHeight(){
        return this.y2 - this.y1;
    }

    public boolean collides(Ball ball){
        if(
            ball.getX() - ball.getRadius() < x1 ||
            ball.getX() + ball.getRadius() > x2 ||
            ball.getY() - ball.getRadius() < y1 ||
            ball.getY() + ball.getRadius() > y2
        ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Container[(" + x1 + ',' + y1 + "),(" + x2 + ',' + y2 + ")]";
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Container container = (Container) obj;

        return this.x1 == container.x1 && this.x2 == container.x2 &&
                this.y1 == container.y1 && this.y2 == container.y2;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.x1;
        result = 31 * result + this.x2;
        result = 31 * result + this.y1;
        result = 31 * result + this.y2;

        return result;
    }
}

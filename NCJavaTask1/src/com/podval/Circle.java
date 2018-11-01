package com.podval;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle[" + "radius=" + radius + ", color='" + color + '\'' + ']';
    }

    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Circle circle = (Circle) obj;

        return radius == circle.radius && color.equals(circle.color);
    }

    @Override
    public int hashCode() {
        int result = 17;
        long f = Double.doubleToLongBits(radius);
        result = 31 * result + (int)(f ^ (f >> 32));
        result = 31 * result + color.hashCode();
        return result;
    }
}

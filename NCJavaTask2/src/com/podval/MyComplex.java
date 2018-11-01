package com.podval;

import java.text.DecimalFormat;

public class MyComplex {
    private double real = 0.0;
    private double image = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double image) {
        this.real = real;
        this.image = image;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImage() {
        return image;
    }

    public void setImage(double image) {
        this.image = image;
    }

    public void setValue(double real, double image){
        this.real = real;
        this.image = image;
    }

    @Override
    public String toString() {
        return "(" + String.format("%.2f", real) +
                (image > 0 ? "+" : "")
                + String.format("%.2f", image) + "i)";
    }

    public boolean isReal(){
        return this.image == 0;
    }

    public boolean isImaginary(){
        if(this.real == 0 && this.image != 0){
            return true;
        }
        else return false;
    }

    public boolean equals(double real, double image){
        return this.real == real && this.image == image;
    }

    public boolean equals(MyComplex another){
        return this.real == another.real && this.image == another.image;
    }

    public double magnitude(){
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.image, 2));
    }

    public double argument(){
        return Math.atan(this.image / this.real);
    }

    public  MyComplex add(MyComplex right){
        this.real += right.real;
        this.image += right.image;

        return this;
    }

    public  MyComplex addNew(MyComplex right){
        return new MyComplex(this.real + right.real, this.image + right.image);
    }

    public MyComplex substuct(MyComplex right){
        this.real -= right.real;
        this.image -= right.image;

        return this;
    }

    public MyComplex substuctNew(MyComplex right){
        return new MyComplex(this.real - right.real, this.image - right.image);
    }

    public MyComplex multiply(MyComplex right){
        double newReal = this.real * right.real - this.image * right.image;
        double newImage = this.image * right.real + this.real * right.image;

        return new MyComplex(newReal, newImage);
    }

    public MyComplex divide(MyComplex right){
        double denominator = right.real * right.real + right.image * right.image;
        double newReal = (this.real * right.real + this.image * right.image) / denominator;
        double newImage = (this.image * right.real - this.real * right.image) / denominator;

        return new MyComplex(newReal, newImage);
    }

    public MyComplex conjugate(){
        return new MyComplex(this.real, -this.image);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        MyComplex complex = (MyComplex) obj;

        return this.real == complex.real && this.image == complex.image;
    }

    @Override
    public int hashCode() {
        int result = 17;
        long f1 = Double.doubleToLongBits(real);
        long f2 = Double.doubleToLongBits(image);
        result = 31 * result + (int)(f1 ^ (f1 >> 32));
        result = 31 * result + (int)(f2 ^ (f2 >> 32));
        return result;
    }
}

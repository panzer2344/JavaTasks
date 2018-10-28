package com.podval.Tests;

import com.podval.Ball;
import com.podval.Container;
import com.podval.MyComplex;
import com.podval.MyPolynomial;

public class tests {
    public static void main(String[] args) {
        /*MyComplex class tests*/
        MyComplex complex1 = new MyComplex(1, 0);
        MyComplex complex2 = new MyComplex(0, 1);
        MyComplex complex3 = new MyComplex(1, 1);
        MyComplex complex4 = new MyComplex(2, 3);

        MyComplex[] complexes = {complex1, complex2, complex3};

        for (MyComplex complex: complexes) {
            System.out.println(complex);
            System.out.println("complex arg = " + String.format("%.2f", complex.argument()));
            System.out.println(" magn = " + String.format("%.2f", complex.magnitude()));
            System.out.println("complex new(add) = " + complex.add(complex4));
            System.out.println("complex = " + complex);
            System.out.println("complex new(addNew) = " + complex.addNew(complex4));
            System.out.println("complex = " + complex);
            System.out.println("complex new(sub) = " + complex.substuct(complex4));
            System.out.println("complex = " + complex);
            System.out.println("complex new(subNew) = " + complex.substuctNew(complex4));
            System.out.println("complex = " + complex);
            System.out.println("multiply result = " + complex.multiply(complex4));
            System.out.println("divide result = " + complex.divide(complex4));
            System.out.println("conjugate = " +complex.conjugate());
            System.out.println();
        }

        /*MyPolinomial class tests*/
        MyPolynomial polynomial1 = new MyPolynomial(3, 2, 1);
        MyPolynomial polynomial2 = new MyPolynomial(6, 4, 0, 3);

        System.out.println(polynomial1);
        System.out.println(polynomial2);

        MyPolynomial polynomial3 = new MyPolynomial(5, 1);
        System.out.println(polynomial1 + " * " + polynomial3 + " = " + polynomial1.multiply(polynomial3));

        MyPolynomial polynomial4 = new MyPolynomial(1, 2, 3, 0, 8, 0, 9, 0, 0);
        System.out.println(polynomial4);

        /*Container and ball tests*/
        Container container = new Container(100, 100, 200, 200);
        Ball ball1 = new Ball(150, 150, 10, 30, 30);

        for(int i = 0; i < 31; i++){
            ball1.move();
            if(!container.collides(ball1)) {
                if(
                        container.getX() + container.getWidth() < ball1.getX() + ball1.getRadius() ||
                        container.getX() > ball1.getX() - ball1.getRadius()
                ){
                    ball1.reflectHorizontal();
                }

                if(
                        container.getY() + container.getHeight() < ball1.getY() + ball1.getRadius() ||
                        container.getY() > ball1.getY() - ball1.getRadius()
                ){
                    ball1.reflectVertical();
                }
            }
            System.out.println(ball1);
        }

    }
}

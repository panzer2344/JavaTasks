package com.podval;

import java.util.Arrays;
import java.util.Vector;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree(){
        return this.coeffs.length - 1;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = this.coeffs.length - 1; i > 0; i--){
            if(this.coeffs[i] != 0){
                if(this.coeffs[i] != 1 && this.coeffs[i] != -1){
                    result += this.coeffs[i];
                }else if(this.coeffs[i] == -1){
                    result += "-";
                }
                result +=  "x" + (i > 1 ? "^" + i : "");
            }
            if(this.coeffs[i] != 0){
                if(i != 1 || this.coeffs[0] != 0){
                    result += " + ";
                }
            }
        }
        result += this.coeffs[0];
        return result;
    }

    public double evaluate(double x){
        double result = 0.0;
        int degree = 0;
        for(int i = 0; i < this.coeffs.length; i++){
            result += this.coeffs[i] * Math.pow(x, degree);
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial right){
        MyPolynomial resultPoly = new MyPolynomial(this.coeffs);
        int length = resultPoly.coeffs.length < right.coeffs.length ? resultPoly.coeffs.length : right.coeffs.length;
        for(int i = 0; i < length; i++){
            resultPoly.coeffs[i] += right.coeffs[i];
        }
        return resultPoly;
    }

    public MyPolynomial multiply(MyPolynomial right){
        int newLength = this.coeffs.length + right.coeffs.length - 1;
        MyPolynomial result = new MyPolynomial(new double[newLength]);

        for(int i = 0; i < right.coeffs.length; i++){
            MyPolynomial tmpP = new MyPolynomial(new double[newLength]);
            for (int j = i; j < i + this.coeffs.length; j++){
                tmpP.coeffs[j] = this.coeffs[j - i] * right.coeffs[i];
            }
            result = result.add(tmpP);
        }
        return result;
    }
}

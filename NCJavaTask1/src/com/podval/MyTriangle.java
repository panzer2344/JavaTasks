package com.podval;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1 = new MyPoint(x1, y1);
        this.v2 = new MyPoint(x2, y2);
        this.v3 = new MyPoint(x3, y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "MyTriangle[" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                ']';
    }

    public double getPerimeter(){
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    public String getType(){
        double lenEdge1 = v1.distance(v2);
        double lenEdge2 = v2.distance(v3);
        double lenEdge3 = v3.distance(v1);

        double delta = getAdequateLenDelta();

        if(lenEdge1 == lenEdge2 || lenEdge2 == lenEdge3 || lenEdge3 == lenEdge1){
            if(Math.abs(lenEdge1 - lenEdge2) <= delta  && Math.abs(lenEdge2 - lenEdge3) <= delta){
                return "Equilateral";
            }
            else{
                return "Isosceles";
            }
        }
        else{
            return "Scalene";
        }
    }

    //from experiment, work on large sizes
    private double getAdequateLenDelta(){
        double avgLen = getAvgLen();
        return 0.03 * avgLen;
    }

    private double getAvgLen(){
        double lenEdge1 = v1.distance(v2);
        double lenEdge2 = v2.distance(v3);
        double lenEdge3 = v3.distance(v1);

        return (lenEdge1 + lenEdge2 + lenEdge3) / 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        MyTriangle triangle = (MyTriangle) obj;

        return v1.equals(triangle.v1) && v2.equals(triangle.v2) && v3.equals(triangle.v3);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + v1.hashCode();
        result = 31 * result + v2.hashCode();
        result = 31 * result + v3.hashCode();
        return result;
    }
}

package com.podval.Test;

import com.podval.*;

public class tests {
    public static void main(String[] args) {
        /* Employee class tests*/
        Employee employee1 = new Employee(0, "John", "Peshi", 1000);
        System.out.println("Employee with start salary: " + employee1);

        /*raiseSalary test*/
        employee1.raiseSalary(10);
        System.out.println("Employee with raised salary: " + employee1);

        /*Book class tests*/
        Author author1 = new Author("Lev Tolstoi", "lt@g.com", 'm');
        Author author2 = new Author("Sveta Sokolova", "ss@ya.ru", 'f');
        Author author3 = new Author("Armen Dzhigarhanyan", "ad@m.ru", 'm');

        Book book1 = new Book("War and Peace", new Author[]{author1, author2, author3}, 100);

        System.out.println("Book authors: " + book1.getAuthorNames());

        /*MyPoint class tests*/
        MyPoint point1 = new MyPoint(4, 3);
        MyPoint point2 = new MyPoint(4, 0);

        System.out.println("Distance from " + point1 + " to " + point2 + " = " + point1.distance(point2));
        System.out.println("Distance from " + point1 + " to (0, 0) = " + point1.distance());
        System.out.println("Distance from " + point1 + " to (8, 6)  = " + point1.distance(8, 6));

        /*MyTriangle class tests*/
        MyPoint point3 = new MyPoint(0, 0);
        MyTriangle triangle1 = new MyTriangle(point1, point2, point3);

        System.out.println(triangle1);
        System.out.println("Triangle perimeter = " + triangle1.getPerimeter());
        System.out.println("Triangle type: " + triangle1.getType());

        MyPoint point4 = new MyPoint(4, 4);
        MyTriangle triangle2 = new MyTriangle(point4, point2, point3);

        System.out.println(triangle2);
        System.out.println("Triangle perimeter = " + triangle2.getPerimeter());
        System.out.println("Triangle type: " + triangle2.getType());

        MyTriangle triangle3 = new MyTriangle(new MyPoint(-200, 0), new MyPoint(200, 0), new MyPoint(0, 350));

        System.out.println(triangle3);
        System.out.println("Triangle perimeter = " + triangle3.getPerimeter());
        System.out.println("Triangle type: " + triangle3.getType());
    }
}

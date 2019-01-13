package com.podval.buyer.models;

import javax.persistence.*;

@Entity
@Table(name = "buyer")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "residence_area", nullable = false)
    private String residenceArea;

    @Column(name = "discount", nullable = false)
    private Integer discount;

    public Buyer(){

    }

    public Buyer(String lastName, String residenceArea, Integer discount) {
        this.lastName = lastName;
        this.residenceArea = residenceArea;
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getResidenceArea() {
        return residenceArea;
    }

    public void setResidenceArea(String residenceArea) {
        this.residenceArea = residenceArea;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", residenceArea='" + residenceArea + '\'' +
                ", discount=" + discount +
                '}';
    }
}

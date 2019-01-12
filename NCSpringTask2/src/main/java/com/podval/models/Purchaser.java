package com.podval.models;

import javax.persistence.*;

@Entity
@Table(name = "purchaser")
public class Purchaser implements IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "residence_area")
    private String residenceArea;

    @Column(name = "discount")
    private int discount;

    public Purchaser(){
    }

    public Purchaser(String lastName, String residenceArea, int discount){
        this.lastName = lastName;
        this.residenceArea = residenceArea;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Purchaser{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", residenceArea='" + residenceArea + '\'' +
                ", discount=" + discount +
                '}';
    }
}

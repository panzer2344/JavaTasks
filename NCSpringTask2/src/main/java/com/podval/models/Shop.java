package com.podval.models;

import javax.persistence.*;

@Entity
@Table(name = "shop")
public class Shop implements IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "area")
    private String area;

    @Column(name = "fee")
    private Integer fee;

    public Shop(){
    }

    public Shop(String name, String area, Integer fee) {
        this.name = name;
        this.area = area;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", fee=" + fee +
                '}';
    }
}

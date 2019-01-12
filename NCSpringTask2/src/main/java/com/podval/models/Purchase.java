package com.podval.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "purchase")
public class Purchase implements IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "seller")
    private Integer sellerId;

    @Column(name = "purchaser")
    private Integer purchaserId;

    @Column(name = "book")
    private Integer bookId;

    @Column(name = "cnt")
    private Integer count;

    @Column(name = "summa")
    private Integer sum;

    public Purchase() {
    }

    public Purchase(
            Timestamp date,
            Integer sellerId,
            Integer purchaserId,
            Integer bookId,
            Integer count,
            Integer sum
    ) {
        this.date = date;
        this.sellerId = sellerId;
        this.purchaserId = purchaserId;
        this.bookId = bookId;
        this.count = count;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Integer purchaserId) {
        this.purchaserId = purchaserId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", date=" + date +
                ", sellerId=" + sellerId +
                ", purchaserId=" + purchaserId +
                ", bookId=" + bookId +
                ", count=" + count +
                ", sum=" + sum +
                '}';
    }
}

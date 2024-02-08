package com.example.stok.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;
    @Column
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> bookIdList;

    private Double totalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Integer> getBookIdList() {
        return bookIdList;
    }

    public void setBookIdList(List<Integer> bookIdList) {
        this.bookIdList = bookIdList;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order() {
    }

    public Order(Integer id, String userName, List<Integer> bookIdList, Double totalPrice) {
        this.id = id;
        this.userName = userName;
        this.bookIdList = bookIdList;
        this.totalPrice = totalPrice;
    }
}

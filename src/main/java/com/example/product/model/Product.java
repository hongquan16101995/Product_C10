package com.example.product.model;

import javax.persistence.*;

@Entity
//annotation đánh dấu đây là 1 thực thể trong dự án
//kết nối ORM để tạo bảng => khóa chính
@NamedQuery(name = "findAll", query = "SELECT p FROM Product AS p")
//annotation dùng để tạo câu query và đặt tên cho nó, nhằm tái sử dụng nhiều lần
public class Product {
    @Id
    //đánh dấu khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column( columnDefinition = "double default 10.0")
    private Double price;
    private Integer quantity;

    //@ManyToOne
    //@ManyToMany
    //FetchType
    //Cascade

    public Product() {
    }

    public Product(Long id, String name, Double price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

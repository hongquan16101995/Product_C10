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
    //annotation hỗ trợ chỉnh sửa thông tin field DB, thêm constrain
    private String name;

    @Column( columnDefinition = "double default 10.0")
    private Double price;
    private Integer quantity;

    //@ManyToOne: tạo liên kết nhiều - một, nhiều cho entity chứa annotation, 1 cho thuộc tính đánh dấu
    //@ManyToMany
    //FetchType
    //Cascade
    @ManyToOne(targetEntity = Category.class)
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

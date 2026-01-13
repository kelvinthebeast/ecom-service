package com.nhanthanhle.ecom.ecomservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Column(name = "OrderItemId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    public OrderItem(long id, Order order, Product product, Integer quantity, BigDecimal price) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne()
    @JoinColumn(name = "fk_order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "fk_product_id")
    private Product product;

    @Column(nullable = false)
    @Min(1)
    private Integer quantity;

    @DecimalMin(value = "0.0",inclusive = false)
    @Column(nullable = false)
    private BigDecimal price; // giá của sản phẩm tại thời điểm khách đặt hàng xong rồi


}

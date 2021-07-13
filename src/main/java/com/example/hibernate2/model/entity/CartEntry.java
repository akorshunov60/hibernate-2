package com.example.hibernate2.model.entity;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "order_products")
public class CartEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn (name = "order_id")
    private Order order;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product;

    @Column (name = "quantity")
    private Long quantity;

    @Column (name = "last_price")
    private BigDecimal lastPrice;
}

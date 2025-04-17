package com.bd_ais.zlagoda.model;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_number", nullable = false, updatable = false)
    private Long category_number;

    @Column(name = "category_name", nullable = false)
    private String category_name;
}

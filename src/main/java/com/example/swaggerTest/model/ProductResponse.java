package com.example.swaggerTest.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private int price;

    // Getters and setters
}
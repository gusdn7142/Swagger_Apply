package com.example.swaggerTest.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductReqeust {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private int price;

    public ProductReqeust(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // Getters and setters
}
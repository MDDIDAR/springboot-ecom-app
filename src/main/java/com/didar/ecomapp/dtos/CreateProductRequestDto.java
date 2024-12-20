package com.didar.ecomapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateProductRequestDto {
    private String title;
    private String image;
    private String description;
    private String category;
    private Double price;
}

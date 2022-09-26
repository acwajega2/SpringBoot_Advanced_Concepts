package com.ug.zest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String title;
    private String description;
    private Integer price;
    private double discountPercentage;
    private double rating;
    private Integer stock;
    private String brand;
    private String category;
    private String thumbnail;
    private List<String> images;

}

package com.ehu.javacafe.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table("BEVERAGE")
public class Beverage {

    @Id
    private Long id;
    private String name;
    private double price;
    private String description;

    // Default no-argument constructor for Jackson
    public Beverage() { }

    // Constructor for convenience if you want to create objects manually
    @JsonCreator
    public Beverage(@JsonProperty("id") Long id,
                    @JsonProperty("name") String name,
                    @JsonProperty("price") double price,
                    @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getters and Setters
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.vinaybedre.gqlfederation.product;

public class Product {
    private final String upc;
    private final String name;
    private final Integer price;
    private final Integer weight;
    private Integer fieldx;

    public Product(String upc, String name, Integer price, Integer weight) {
        this.upc = upc;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getUpc() {
        return upc;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getFieldx() {
        return fieldx;
    }

    public void setFieldx(Integer fieldx) {
        this.fieldx = fieldx;
    }
}

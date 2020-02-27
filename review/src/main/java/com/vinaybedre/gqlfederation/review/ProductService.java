package com.vinaybedre.gqlfederation.review;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    public List<Product> products = new ArrayList<>();
    public List<Review> reviews = new ArrayList<>();

    public ProductService() {
        products.add(new Product("1"));
        products.add(new Product("2"));
        products.add(new Product("3"));

        reviews.add(new Review("1","Love it!", new User("1"), new Product("1")));
        reviews.add(new Review("2","Too expensive.", new User("1"), new Product("2")));
        reviews.add(new Review("3","Could be better.", new User("2"), new Product("3")));
        reviews.add(new Review("4","Prefer something else.", new User("2"), new Product("1")));
    }

    public Product lookupProduct(String upc) {
        Product product1 = products.stream().filter(product -> product.getUpc().equals(upc)).findAny().get();
        product1.setReviews(reviews.stream()
                .filter(review -> review.getProduct().getUpc().equals(product1.getUpc()))
                .collect(Collectors.toList()));
        return product1;
    }
}

package com.vinaybedre.gqlfederation.product;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    public List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product("1", "Table", 899, 100));
        products.add(new Product("2", "Couch", 1299, 54));
        products.add(new Product("3", "Chair", 54, 50));
    }

    @NotNull
    public Product lookupProduct(@NotNull String upc) {
        return products.stream().filter(product -> product.getUpc().equals(upc)).findAny().get();
    }
}

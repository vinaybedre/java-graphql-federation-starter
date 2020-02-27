package com.vinaybedre.gqlfederation.product;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Query implements GraphQLQueryResolver {

    @Autowired
    ProductService productService;

    public List<Product> topProducts(Integer first, final DataFetchingEnvironment dataFetchingEnvironment) {
        return productService.products.stream().limit(first).collect(Collectors.toList());
    }
}
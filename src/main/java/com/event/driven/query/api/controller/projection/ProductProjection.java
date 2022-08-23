package com.event.driven.query.api.controller.projection;
import java.util.*;

import com.event.driven.command.api.data.Product;
import com.event.driven.command.api.data.ProductRepository;
import com.event.driven.command.api.model.ProductRestModel;
import com.event.driven.query.api.controller.query.GetProductsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class ProductProjection {

    private ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @QueryHandler
    public List<ProductRestModel> handle(GetProductsQuery getProductsQuery) {
        List<Product> products;
        products = ProductRepository.findAll();


    }

}

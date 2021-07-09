package com.wps.wpscac.products;

import com.wps.wpscac.products.entity.Product;
import com.wps.wpscac.products.exception.ProductNotFoundException;
import com.wps.wpscac.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("products")
public class ProductsController {

    private ProductRepository productRepository;

    @Autowired
    public ProductsController(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAll() {
        return StreamSupport
                .stream(productRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/{productId}")
    public Product get(@PathVariable("productId") String productId) {
        return productRepository
                .findById(productId)
                .orElseThrow(ProductNotFoundException::new);
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Product dto) {
        productRepository.save(dto);
    }
}

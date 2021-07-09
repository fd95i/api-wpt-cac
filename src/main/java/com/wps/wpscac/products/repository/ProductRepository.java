package com.wps.wpscac.products.repository;

import com.wps.wpscac.products.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ProductRepository")
public interface ProductRepository extends CrudRepository<Product, String> {
}

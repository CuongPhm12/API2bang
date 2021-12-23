package com.codegym.api2bang.repository;

import com.codegym.api2bang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}

package com.pranav.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}

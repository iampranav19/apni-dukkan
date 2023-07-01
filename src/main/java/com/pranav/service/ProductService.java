package com.pranav.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.entity.Product;
import com.pranav.repo.ProductRepo;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public void createProduct(Product product)
	{
		log.info("Creating Product {}",product);
		productRepo.save(product);
	}
	
	public List<Product> listOfProducts()
	{
		log.info("Getting all products");
		return productRepo.findAll();
	}
	
	public void deleteProductById(int id)
	{
		log.info("Deleting the Product with Id {}",id);
		productRepo.deleteById(id);
	}
	
	public Product getProductBasedOnId(int pid)
	{
		log.info("Fetching the Product for Id {}",pid);
		return productRepo.findById(pid).get();
		
	}
	public Product updateProduct(int pid, Product product )
	{
		Product updatedProduct = getProductBasedOnId(pid);
		updatedProduct.setName(product.getName());
		updatedProduct.setDescription(product.getDescription());
		updatedProduct.setPrice(product.getPrice());
		productRepo.save(updatedProduct);
		return updatedProduct;
	}

}

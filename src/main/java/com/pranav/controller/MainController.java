package com.pranav.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.pranav.entity.Product;
import com.pranav.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String home(Model model)
	{
		List<Product> listOfProducts = productService.listOfProducts();
		if (listOfProducts == null) {
	        listOfProducts = new ArrayList<>(); // Create an empty list if the productList is null
	    }
		model.addAttribute("productList",listOfProducts);
		
		return "index";
	}
	
	@GetMapping("/add")
	public String addProduct(Model model)
	{
		model.addAttribute("title", "Apni Desi Dukkan- Add Product Page");
		return "add_product";
	}
	
	@PostMapping("/saveProduct")
	public RedirectView saveProduct(@ModelAttribute("product") Product product)
	{
		productService.createProduct(product);
		RedirectView redirectView=new RedirectView("/");
		return redirectView;
	}
	
	// Handler to Delete
	@GetMapping("/delete/{pid}")
	public RedirectView deleteProduct(@PathVariable("pid") int pid)
	{
		productService.deleteProductById(pid);
		RedirectView redirectView=new RedirectView("/");
		return redirectView;
	}
	
	@GetMapping("/update")
	public String updateProduct(@RequestParam("pid") int pid, Model model) {
	    Product product = productService.getProductBasedOnId(pid);
	    System.out.println("Pid "+pid);
	    System.out.println("Product "+product);
	    model.addAttribute("product", product);
	    model.addAttribute("pid",pid);
	    return "update-form";
	  
	}
	@PostMapping("/updateProduct")
	public RedirectView updateProduct(@ModelAttribute("product") Product product)
	{
		Product updatedProduct=new Product(product.getPId(), product.getName(), product.getDescription(), product.getPrice());			
		productService.createProduct(updatedProduct);
		RedirectView redirectView=new RedirectView("/");
		return redirectView;
	}

}

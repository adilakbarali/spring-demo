package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	private ProductService service;

	@Autowired
	public ProductController(ProductService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody Product p) {
		Product created = this.service.createProduct(p);
		ResponseEntity<Product> response = new ResponseEntity<Product>(created, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(this.service.getAllProducts());
	}

	@GetMapping("/get/{id}")
	public Product getProduct(@PathVariable Integer id) {
		return this.service.getProduct(id);
	}

	@PutMapping("/replace/{id}")
	public ResponseEntity<Product> replaceProduct(@PathVariable Integer id, @RequestBody Product p) {
		Product replaced = this.service.replaceProduct(id, p);
		ResponseEntity<Product> response = new ResponseEntity<Product>(replaced, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
		this.service.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

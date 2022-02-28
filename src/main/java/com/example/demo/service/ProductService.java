package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Product;

@Service
public class ProductService {

	private List<Product> products = new ArrayList<>();

	public Product createProduct(Product p) {
		this.products.add(p);
		Product created = this.products.get(products.size() - 1);
		return created;
	}

	public List<Product> getAllProducts() {
		return this.products;
	}

	public Product getProduct(Integer id) {
		return this.products.get(id);
	}

	public Product replaceProduct(Integer id, Product p) {
		Product body = this.products.set(id, p);
		return body;
	}

	public void deleteProduct(@PathVariable Integer id) {
		this.products.remove(id.intValue());
	}

}

package com.PIDEV.demo.services;


import com.PIDEV.demo.entities.Product;

import java.util.List;


public interface ProductService {
	Product addProduct(Product p);
	Product getProductById(int idProduct);
	List<Product> getAllProducts();
	 void deleteProduct(int idProduct);
	 Product updateProductById(Product product,int idProduct); 

}

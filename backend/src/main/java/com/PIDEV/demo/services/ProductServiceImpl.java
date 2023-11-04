package com.PIDEV.demo.services;

import com.PIDEV.demo.entities.Product;
import com.PIDEV.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class 	ProductServiceImpl  implements ProductService{

	 @Autowired
	 ProductRepository iPorudctRepository;
	
	@Override
	public Product addProduct(Product p) {
		
		return iPorudctRepository.save(p);
	}


	@Override
	public Product getProductById(int idProduct) {
		return  iPorudctRepository.findById(idProduct).orElse(null);
	}

	@Override
	public List<Product> getAllProducts() {
		return iPorudctRepository.findAll();
	}


	@Override
	public void deleteProduct(int idProduct) {
       iPorudctRepository.deleteById(idProduct);		
	}


	@Override
	public Product updateProductById(Product product, int idProduct) {
		Product found= iPorudctRepository.findById(idProduct).orElse(null);
		found.setCategory(product.getCategory());
		found.setDescrp(product.getDescrp());
		found.setName(product.getName());
		found.setPrice(product.getPrice());
		found.setReferance(product.getReferance());
		found.setQuantite(product.getQuantite());
		iPorudctRepository.saveAndFlush(found);
		return found;
	}

}

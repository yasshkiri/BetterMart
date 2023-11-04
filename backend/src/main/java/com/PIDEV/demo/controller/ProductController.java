package com.PIDEV.demo.controller;

import com.PIDEV.demo.entities.Product;
import com.PIDEV.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;


    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product p) {
        return new ResponseEntity<>(productService.addProduct(p), HttpStatus.CREATED);
    }

    @GetMapping("/getAllProduct")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();

    }


    @GetMapping("/getProduct/{IdProduct}")
    @ResponseBody
    public Product getProductById(@PathVariable("IdProduct") int idProduct) {
        return productService.getProductById(idProduct);
    }

    @DeleteMapping("/deleteProduct/{idProduct}")
    @ResponseBody
    void deleteProduct(@PathVariable("idProduct") int idProduct) {
        productService.deleteProduct(idProduct);
    }

    @PutMapping("/modifyProductByID/{idProduct}")
    @ResponseBody
    public Product ModifyProductById(@PathVariable("idProduct") int idProduct, @RequestBody Product Product) {
        return productService.updateProductById(Product, idProduct);
    }
}

package com.example.product.controller;

import com.example.product.dto.ProductDTO;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/products/")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void productService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "{id}")
    public ProductDTO getProduct(@PathVariable(name = "id") String id) {
        return productService.getProduct(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        String savedId = productService.createProduct(productDTO);
        return productService.getProduct(savedId);
    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO updateProduct(@PathVariable(name = "id") String id, @RequestBody ProductDTO productDTO) {
        String updatedId = productService.updateProduct(id, productDTO);
        return productService.getProduct(updatedId);
    }

    @DeleteMapping(path = "{id}")
    public void deleteProduct(@PathVariable(name = "id") String id) {
        productService.deleteProduct(id);
    }
}

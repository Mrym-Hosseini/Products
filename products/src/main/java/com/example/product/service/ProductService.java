package com.example.product.service;

import com.example.product.dto.ProductDTO;
import com.example.product.model.ProductEntity;
import com.example.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    private Logger LOG = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public void productRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO getProduct(String id) {
        LOG.info("Getting Product...");
        Optional<ProductEntity> optional = productRepository.findById(id);
        ProductDTO productDTO = new ProductDTO();
        if (optional.isPresent()) {
            ProductEntity entity = optional.get();
            productDTO.setName(entity.getName());
            productDTO.setId(entity.getId());
            productDTO.setType(entity.getType());
            productDTO.setCategory(entity.getCategory());
            productDTO.setDescription(entity.getDescription());
            productDTO.setPrice(entity.getPrice());
        }
        return productDTO;
    }

    public String createProduct(ProductDTO productDTO) {
        ProductEntity productToSave = new ProductEntity();
        productToSave.setName(productDTO.getName());
        productToSave.setType(productDTO.getType());
        productToSave.setCategory(productDTO.getCategory());
        productToSave.setDescription(productDTO.getDescription());
        productToSave.setPrice(productDTO.getPrice());
        try {
            LOG.info("Saving Product...");
            ProductEntity savedProduct = productRepository.save(productToSave);
            return savedProduct.getId();
        } catch (Exception e) {
            LOG.error("An Error occurred during saving process : " + e.getMessage());
        }
        return null;
    }

    public String updateProduct(String id, ProductDTO productDTO) {
        Optional<ProductEntity> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            LOG.info("Updating Product...");
            ProductEntity entity = optional.get();
            try {
                entity.setName(productDTO.getName());
                entity.setType(productDTO.getType());
                entity.setCategory(productDTO.getCategory());
                entity.setDescription(productDTO.getDescription());
                entity.setPrice(productDTO.getPrice());
                ProductEntity updated = productRepository.save(entity);
                return updated.getId();
            } catch (Exception e) {
                LOG.error("An Error occurred during updating process : " + e.getMessage());
            }
        }
        return null;
    }

    public void deleteProduct(String id) {
        try {
            LOG.info("Deleting Product...");
            productRepository.deleteById(id);
        } catch (Exception e) {
            LOG.error("An Error occurred during deleting product : " + e.getMessage());
        }
    }
}

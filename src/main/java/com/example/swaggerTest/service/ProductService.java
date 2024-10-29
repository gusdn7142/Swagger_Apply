package com.example.swaggerTest.service;


import com.example.swaggerTest.Entity.Product;
import com.example.swaggerTest.global.response.ApiException;
import com.example.swaggerTest.global.util.LoggingUtil;
import com.example.swaggerTest.model.ProductReqeust;
import com.example.swaggerTest.model.ProductResponse;
import com.example.swaggerTest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.swaggerTest.global.response.ResponseCode.NULL_Product;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(ProductReqeust productReqeust) {
        ProductResponse productResponse = productRepository.save(productReqeust);
        LoggingUtil.logData("상품 정보", productResponse);
        return productResponse;
    }

    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> productResponseList = productRepository.findAll();
        LoggingUtil.logData("상품 정보 리스트", productResponseList);
        return productResponseList;
    }


    public ProductResponse updateProduct(Long id, ProductReqeust productReqeust) {
        Product productExistence = productRepository.findById(id);
        if (productExistence == null) {                 //Role : exist DB
            throw new ApiException(NULL_Product);
        }

        ProductResponse productResponse = productRepository.updateProduct(id, productReqeust);
        LoggingUtil.logData("상품 정보 수정 내역", productResponse);
        return productResponse;
    }

    public int deleteProduct(Long id) {
        if (productRepository.findById(id) != null) {
            int result = productRepository.deleteProduct(id);
            LoggingUtil.logData("상품정보 삭제 완료", result);
            return result;
        } else {
            throw new ApiException(NULL_Product);
        }
    }


}
package com.example.swaggerTest.controller;


import com.example.swaggerTest.Entity.Product;
import com.example.swaggerTest.global.response.ApiResponse;
import com.example.swaggerTest.global.response.ApiResponseHeader;
import com.example.swaggerTest.global.response.ResponseCode;
import com.example.swaggerTest.model.ProductReqeust;
import com.example.swaggerTest.model.ProductResponse;
import com.example.swaggerTest.service.ProductService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.swaggerTest.global.response.ResponseCode.SUCCESS;

@RestController
@RequestMapping("/products")
public class ProductController implements ProductControllerDocs {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * init data
     */
    @PostConstruct
    public void init() {
        ProductReqeust productReqeust1 = new ProductReqeust("과자", 1500);
        ProductReqeust productReqeust2 = new ProductReqeust("노트북", 1000000);
        ProductReqeust productReqeust3 = new ProductReqeust("치약", 2000);
        productService.createProduct(productReqeust1);
        productService.createProduct(productReqeust2);
        productService.createProduct(productReqeust3);
    }

    /**
     * Create Product
     */
    @PostMapping("")
    public ApiResponse<ProductResponse> createProduct(@Valid @RequestBody ProductReqeust productReqeust) {
        ProductResponse productResponse = productService.createProduct(productReqeust);
        return ApiResponse.of(ApiResponseHeader.of(SUCCESS), productResponse);

    }

    /**
     * Get Products
     */
    @GetMapping("")
    public ApiResponse<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> productResponseList = productService.getAllProducts();
        return ApiResponse.of(ApiResponseHeader.of(SUCCESS), productResponseList);
    }

    /**
     * Update Product
     */
    @PatchMapping("/{id}")
    public ApiResponse<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductReqeust productReqeust) {
        ProductResponse productResponse = productService.updateProduct(id, productReqeust);
        return ApiResponse.of(ApiResponseHeader.of(SUCCESS), productResponse);
    }

    /**
     * Delete Product
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Integer> deleteProduct(@PathVariable Long id) {
        int result = productService.deleteProduct(id);
        return ApiResponse.of(ApiResponseHeader.of(SUCCESS), result);
    }

}
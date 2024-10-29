package com.example.swaggerTest.repository;


import com.example.swaggerTest.Entity.Product;
import com.example.swaggerTest.global.response.ApiException;
import com.example.swaggerTest.model.ProductReqeust;
import com.example.swaggerTest.model.ProductResponse;
import org.springframework.stereotype.Repository;
import java.util.*;
import static com.example.swaggerTest.global.response.ResponseCode.NULL_Product;


@Repository
public class ProductRepository {
    private final Map<Long, Product> productStorage = new HashMap<>();
    private long currentId = 1;

    public ProductResponse save(ProductReqeust productReqeust) {

        //Insert
        Product productCreation = Product.builder()     //Role : create Table Row
                .name(productReqeust.getName())
                .price(productReqeust.getPrice())
                .id(currentId++)
                .build();
        productStorage.put(productCreation.getId(), productCreation);            //Role : insert DB
        Product productSelection = productStorage.get(productCreation.getId());  //Role : return DBValue

        return ProductResponse.builder()                                         //Role : mapping DTO
                .id(productSelection.getId())
                .name(productSelection.getName())
                .price(productSelection.getPrice())
                .build();
    }

    public List<ProductResponse> findAll() {
        List<Product> productList = new ArrayList<>(productStorage.values());   //Role : select DB
        List<ProductResponse> productResponseList = new ArrayList<>();

        for (Product product : productList) {                  //Role : mapping DTO
            productResponseList.add(ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .build()
            );
        }
        return productResponseList;
    }

    public Product findById(Long id) {
        Product productSelection = productStorage.get(id);
        return productSelection;
    }

    public ProductResponse updateProduct(Long id, ProductReqeust productRequest) {
        Product productUpdate = productStorage.get(id);

        if(productRequest.getName() != null && !"".equals(productRequest.getName()))
            productUpdate.setName(productRequest.getName());   //Role : update DB

        if(productRequest.getPrice() != 0)
            productUpdate.setPrice(productRequest.getPrice()); //Role : update DB

        productStorage.put(id, productUpdate);
        Product productSelection = productStorage.get(id);

        return ProductResponse.builder()                                         //Role : mapping DTO
                .id(productSelection.getId())
                .name(productSelection.getName())
                .price(productSelection.getPrice())
                .build();
    }

    public int deleteProduct(Long id) {
        Product product = productStorage.remove(id);
        return 0;
    }


}
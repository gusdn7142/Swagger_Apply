package com.example.swaggerTest.controller;


import com.example.swaggerTest.global.response.ApiResponse;
import com.example.swaggerTest.model.ProductReqeust;
import com.example.swaggerTest.model.ProductResponse;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@Tag(name = "1. 상품 도메인", description = "Product API")
public interface ProductControllerDocs {

    /**
     * Create Product
     */
    @Operation(summary = "1) 상품 정보 저장 API", description = "상품 정보를 DB에 저장하는 API ")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, content = @Content(examples = {
			@ExampleObject(name = "validRequest", value = "{ \"name\": \"과자\", \"price\": 2000 }",  description = "Valid Request Example"),
			@ExampleObject(name = "invalidRequest", value = "{ \"name\": \"과자\", \"price\": -1000 }",  description = "Invalid Request Example")
	}))
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "정상 응답",
                    content = @Content(
                            mediaType = "application/json",
                            //schema = @Schema(implementation = ApiResponse.class))
                            examples = @ExampleObject(value = """
                                {
                                    "header": {
                                        "retcode": 200,
                                        "message": "응답 성공"
                                    },
                                    "body": {
                                        "id": 4,
                                        "name": "과자",
                                        "price": "2000"
                                    }
                                }
                            """)
                    )
            ),
	        //@ApiResponse(responseCode = "400", description = "리프레시 토큰이 유효하지 않습니다", content = @Content(schema = @Schema(implementation = BaseResponse.class))),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200_1", description = "유효성 검증 실패",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = """
                                {
                                    "header": {
                                        "retcode": 400,
                                        "message": "Price must be greater than or equal to 0"
                                    },
                                    "body": null
                                }
                            """)
                    )
            ) }
    )
    public ApiResponse<ProductResponse> createProduct(@Valid @RequestBody ProductReqeust productReqeust);



    /**
     * Get Products
     */
    //@Hidden
    @Operation(summary = "2) 전체 상품 리스트 조회 API", description = "전체 상품 리스트를 DB에서 조회하는 API ")
    public ApiResponse<List<ProductResponse>> getAllProducts();


    /**
     * Update Product
     */
    //@Hidden
    @Operation(summary = "3) 상품 정보 업데이트 API", description = "특정 상품 정보를 업데이트하는 API ")
    public ApiResponse<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductReqeust productReqeust);

    /**
     * Delete Product
     */
    //@Hidden
    @Operation(summary = "4) 상품 정보 삭제 API", description = "특정 상품 정보를 삭제하는 API ")
    public ApiResponse<Integer> deleteProduct(@PathVariable Long id);

}
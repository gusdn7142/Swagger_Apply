package com.example.swaggerTest;



import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SecurityScheme(
		name = "Bearer Authentication",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		scheme = "bearer"
)
//		paramName = "accessToken",
//		description = "123456"

//jar 실행용
@SpringBootApplication
public class SwaggerTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerTestApplication.class, args);
	}


//	@Bean
//	public OpenAPI customOpenAPI(@Value("${application-version}") String appVersion) {
//		return new OpenAPI()
//				.info(new Info()
//						.title("스웨거 API Document")
//						.version(appVersion));
//	}


//				.description(appDesciption));
//						.termsOfService("http://swagger.io/terms/")
//				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
}

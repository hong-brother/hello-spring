package com.hello.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Swagger Setting
     * @return
     */
    @Bean
    public Docket swaggerAPI(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(swaggerApiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.hello.spring"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    /**
     * swagger API Information
     * @return
     */
    private ApiInfo swaggerApiInfo(){
        return new ApiInfoBuilder().title("Hello Spring")
                .description("스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술 강의 ")
                .license("hsnam").version("1.0.0").build();
    }
}

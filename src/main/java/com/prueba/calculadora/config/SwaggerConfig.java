package com.prueba.calculadora.config;


import static springfox.documentation.builders.PathSelectors.any;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.prueba.calculadora.controllers"))
        .paths(any())
        .build()
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfo(
        "Servicio de calculadora",
        "Este servicio expone un API que a partir de unos parámetros de entrada es capaz de realizar operaciones aritméticas y tracear el resultado",
        "0.0.1-SNAPSHOT",
        "",
        new Contact("Jesús Díaz García", "",
            "jesusdiazgarcia@gmail.com"),
        "", "", Collections.emptyList());
  }
}
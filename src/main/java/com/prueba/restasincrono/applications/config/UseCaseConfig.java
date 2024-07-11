package com.prueba.restasincrono.applications.config;

import com.prueba.restasincrono.domain.product.gateway.ProductRepository;
import com.prueba.restasincrono.domain.usecase.product.FindProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public FindProductUseCase queryRequirementUseCase(ProductRepository repository){
        return new FindProductUseCase(repository);
    }
}

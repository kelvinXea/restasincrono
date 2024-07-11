package com.prueba.restasincrono.domain.usecase.product;

import com.prueba.restasincrono.domain.product.gateway.ProductRepository;
import com.prueba.restasincrono.infraestructure.entrypoints.dto.product.ProductDTO;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindProductUseCase {

    private final ProductRepository productRepository;

    public Mono<ProductDTO> findById(Long id) {
        return productRepository.findById(id)
                .map(ProductDTO::productConverter)
                .onErrorResume(e ->{
                    System.err.println("Error finding the product: " + e.getMessage());
                    return Mono.empty();
                });
    }

}

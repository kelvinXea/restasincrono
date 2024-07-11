package com.prueba.restasincrono.domain.product.gateway;

import com.prueba.restasincrono.domain.product.Product;
import reactor.core.publisher.Mono;

public interface ProductRepository {
    Mono<Product> findById(Long id);
}

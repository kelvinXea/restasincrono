package com.prueba.restasincrono.infraestructure.adapters.repository.product;

import com.prueba.restasincrono.domain.product.Product;
import com.prueba.restasincrono.domain.product.gateway.ProductRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepositoryAdapter implements ProductRepository {

    @Override
    public Mono<Product> findById(Long id) {
        List<Product> products = getData();

        return Mono.justOrEmpty(products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null));
    }

    private List<Product> getData(){
        return Arrays.asList(
                new Product(1L, "Acer Lat", "Portatil", 100000L),
                new Product(2L, "Iphone 99", "Smartphone", 999999999L),
                new Product(3L, "Steam Deck", "Handheld PC", 2500000L)
        );

    }
}

package com.prueba.restasincrono.infraestructure.entrypoints.wsapi.products;

import com.prueba.restasincrono.domain.usecase.product.FindProductUseCase;
import com.prueba.restasincrono.infraestructure.entrypoints.dto.product.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProductService {
    private final FindProductUseCase useCase;
    @GetMapping(path = "/{id}")
    public Mono<ProductDTO> getProductById(@PathVariable("id") Long id){
        return useCase.findById(id);
    }
}

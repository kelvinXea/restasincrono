package com.prueba.restasincrono.infraestructure.entrypoints.wsapi.products;

import com.prueba.restasincrono.domain.product.Product;
import com.prueba.restasincrono.domain.usecase.product.FindProductUseCase;
import com.prueba.restasincrono.infraestructure.entrypoints.dto.product.ProductDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private FindProductUseCase useCase;

    @Before
    public void init() {
        ProductDTO response = new ProductDTO("A","B",10L);
        when(useCase.findById(any())).thenReturn(Mono.just(response));
    }

    @Test
    public void shouldFindById(){
        Mono<ProductDTO> responseMono = service.getProductById(1L);
        StepVerifier.create(responseMono).assertNext(response -> assertThat(response.getName()).isEqualTo("A"))
                .verifyComplete();
    }
}

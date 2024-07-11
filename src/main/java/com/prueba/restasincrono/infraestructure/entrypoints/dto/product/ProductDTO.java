package com.prueba.restasincrono.infraestructure.entrypoints.dto.product;

import com.prueba.restasincrono.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    String name;
    String description;
    Long price;

    public static ProductDTO productConverter(Product product) {
        return new ProductDTO(product.getName(), product.getDescription(), product.getValue());
    }
}

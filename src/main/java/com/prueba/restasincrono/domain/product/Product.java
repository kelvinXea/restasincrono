package com.prueba.restasincrono.domain.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@Builder(toBuilder = true)
public class Product {
    final Long id;
    final String name;
    final String description;
    final Long value;
}

package com.hit.product.domains.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPropertiesDto {

    private String color;

    private Integer size;

    private String slugColor;

    private Integer currentNumber;

    private Double priceOld;

    private Double priceCurrent;

}

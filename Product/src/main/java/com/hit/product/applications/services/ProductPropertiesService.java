package com.hit.product.applications.services;

import com.hit.product.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.product.domains.dtos.ProductPropertiesDto;
import com.hit.product.domains.entities.Product;
import com.hit.product.domains.entities.ProductProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductPropertiesService {

    List<ProductProperties> getAll();

    ProductProperties getProductPropertiesById(Long id);

    ProductProperties updateProductProperties(Long id, ProductPropertiesDto productPropertiesDTO);

    TrueFalseResponse deleteProductProperties(Long id);

    Product createListProductPropertiesForProduct(Long idProduct, List<ProductPropertiesDto> productPropertiesDTOs);
}

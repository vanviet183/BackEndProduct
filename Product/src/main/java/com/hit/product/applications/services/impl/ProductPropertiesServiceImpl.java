package com.hit.product.applications.services.impl;

import com.github.slugify.Slugify;
import com.hit.product.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.product.applications.repositories.ProductPropertiesRepository;
import com.hit.product.applications.repositories.ProductRepository;
import com.hit.product.applications.services.ProductPropertiesService;
import com.hit.product.configs.exceptions.NotFoundException;
import com.hit.product.domains.dtos.ProductPropertiesDto;
import com.hit.product.domains.entities.Product;
import com.hit.product.domains.entities.ProductProperties;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductPropertiesServiceImpl implements ProductPropertiesService {

    @Autowired
    ProductPropertiesRepository productPropertiesRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductProperties> getAll() {
        return productPropertiesRepository.findAll();
    }

    @Override
    public ProductProperties getProductPropertiesById(Long id) {
        Optional<ProductProperties> productProperties = productPropertiesRepository.findById(id);
        checkProductPropertiesException(productProperties);
        return productProperties.get();
    }

    @Override
    @Transactional
    public Product createListProductPropertiesForProduct(Long idProduct, List<ProductPropertiesDto> productPropertiesDTOs) {
        Optional<Product> product = productRepository.findById(idProduct);
        checkProductException(product);
        Slugify slug = new Slugify();

        productPropertiesDTOs.forEach(productPropertiesDto -> {
            ProductProperties productProperties = modelMapper.map(productPropertiesDto, ProductProperties.class);
            productProperties.setSlugColor(slug.slugify(productPropertiesDto.getColor()));
            productProperties.setProduct(product.get());
            productPropertiesRepository.save(productProperties);
        });

        return product.get();
    }


    @Override
    public ProductProperties updateProductProperties(Long id, ProductPropertiesDto productPropertiesDto) {
        Optional<ProductProperties> productProperties = productPropertiesRepository.findById(id);
        checkProductPropertiesException(productProperties);

        modelMapper.map(productPropertiesDto, productProperties.get());

        Slugify slug = new Slugify();
        String result = slug.slugify(productPropertiesDto.getColor());
        productProperties.get().setSlugColor(result);

        return productPropertiesRepository.save(productProperties.get());
    }

    @Override
    public TrueFalseResponse deleteProductProperties(Long id) {
        Optional<ProductProperties> productProperties = productPropertiesRepository.findById(id);
        checkProductPropertiesException(productProperties);
        productPropertiesRepository.deleteById(id);
        return new TrueFalseResponse(true);
    }


    private void checkProductPropertiesException(Optional<ProductProperties> productProperties) {
        if(productProperties.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
    }

    private void checkProductException(Optional<Product> product) {
        if(product.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
    }

}

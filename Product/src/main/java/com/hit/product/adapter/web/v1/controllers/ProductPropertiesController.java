package com.hit.product.adapter.web.v1.controllers;

import com.hit.product.adapter.web.base.RestApiV1;
import com.hit.product.adapter.web.base.VsResponseUtil;
import com.hit.product.applications.constants.UrlConstant;
import com.hit.product.applications.services.ProductPropertiesService;
import com.hit.product.domains.dtos.ProductPropertiesDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestApiV1
public class ProductPropertiesController {

    @Autowired
    ProductPropertiesService productPropertiesService;

    @ApiOperation(value = "Get All Properties Of Products")
    @GetMapping(UrlConstant.ProductProperties.DATA_PRODUCT_PROPERTIES)
    public ResponseEntity<?> getListProductProperties() {
        return VsResponseUtil.ok(productPropertiesService.getAll());
    }

    @ApiOperation(value = "Get Product Properties By Id")
    @GetMapping(UrlConstant.ProductProperties.DATA_PRODUCT_PROPERTIES_ID)
    public ResponseEntity<?> getProductProperties(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(productPropertiesService.getProductPropertiesById(id));
    }

    @ApiOperation(value = "Create Properties Of Product")
    @PostMapping(UrlConstant.ProductProperties.DATA_PRODUCT_PROPERTIES_FOR_PRODUCT)
    public ResponseEntity<?> createProductPropertiesForProduct(@PathVariable("idProduct") Long idProduct,
                                                          @RequestBody List<ProductPropertiesDto> ProductPropertiesDTOs) {
        return VsResponseUtil.ok(productPropertiesService.createListProductPropertiesForProduct(idProduct, ProductPropertiesDTOs));
    }

    @ApiOperation(value = "Update Properties Of Product")
    @PatchMapping(UrlConstant.ProductProperties.DATA_PRODUCT_PROPERTIES_ID)
    public ResponseEntity<?> updateProductProperties(@PathVariable("id") Long id, @RequestBody ProductPropertiesDto productColorDTO) {
        return VsResponseUtil.ok(productPropertiesService.updateProductProperties(id, productColorDTO));
    }

    @ApiOperation(value = "Delete Properties Of Product")
    @DeleteMapping(UrlConstant.ProductProperties.DATA_PRODUCT_PROPERTIES_ID)
    public ResponseEntity<?> deleteProductProperties(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(productPropertiesService.deleteProductProperties(id));
    }
}

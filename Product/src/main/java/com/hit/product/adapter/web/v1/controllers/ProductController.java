package com.hit.product.adapter.web.v1.controllers;

import com.hit.product.adapter.web.base.RestApiV1;
import com.hit.product.adapter.web.base.VsResponseUtil;
import com.hit.product.applications.constants.UrlConstant;
import com.hit.product.applications.services.ProductService;
import com.hit.product.domains.dtos.ProductDto;
import com.hit.product.domains.entities.Product;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestApiV1
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(UrlConstant.Product.DATA_PRODUCT)
    @ApiOperation(value = "Get All Products In Database")
    public ResponseEntity<?> getProducts(@RequestParam(name = "page", required = false, defaultValue = "") Integer page) {
        return ResponseEntity.ok().body(productService.getAllByPage(page));
    }

    @GetMapping(UrlConstant.Product.DATA_PRODUCT_NEWS)
    @ApiOperation(value = "Get Products Newest")
    public ResponseEntity<?> getProductsNewest() {
        return ResponseEntity.ok().body(productService.getProductsNewest());
    }

    @ApiOperation(value = "Get Products Best Seller")
    @GetMapping(UrlConstant.Product.DATA_PRODUCT_SELL_BEST)
    public ResponseEntity<?> getProductsBestSeller() {
        return ResponseEntity.ok().body(productService.getProductsBestSeller());
    }

    @ApiOperation(value = "Get Products Sort By Require")
    @GetMapping(UrlConstant.Product.DATA_PRODUCT_SORT)
    public ResponseEntity<?> getProductsSort(@RequestParam(name = "by") String type) {
        return ResponseEntity.ok().body(productService.getProductsSort(type));
    }

    @ApiOperation(value = "Get List Rate Of Product")
    @GetMapping(UrlConstant.Product.DATA_PRODUCT_GET_RATE)
    public ResponseEntity<?> getRateOfProduct(@PathVariable(name = "idProduct") Long idProduct) {
        return ResponseEntity.ok().body(productService.getProductRateByIdProduct(idProduct));
    }

    @ApiOperation(value = "Filter Product")
    @PostMapping(UrlConstant.Product.DATA_PRODUCT_FILTER)
    public ResponseEntity<?> getProductsByFilter(@RequestParam(name = "type", required = false, defaultValue = "") List<String> types,
                                                 @RequestParam(name = "size", required = false, defaultValue = "") List<Integer> sizes,
                                                 @RequestParam(name = "color", required = false, defaultValue = "") List<String> colors,
                                                 @RequestParam(name = "brand", required = false, defaultValue = "") List<String> brands) {
        return ResponseEntity.ok().body(productService.getProductsByFilter(types, sizes, colors, brands));
    }

    @ApiOperation(value = "Get Products Newest")
    @GetMapping(UrlConstant.Product.DATA_PRODUCT_ID)
    public ResponseEntity<?> getProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @PostMapping(UrlConstant.Product.DATA_PRODUCT_CREATE)
    @ApiOperation(value = "Create Product")
    public ResponseEntity<?> createProduct(@PathVariable("idCategory") Long idCategory,
                                           @ModelAttribute ProductDto productDto,
                                           @RequestParam(name = "img", required = false) List<MultipartFile> multipartFiles) {
        return VsResponseUtil.ok(productService.createProduct(idCategory, productDto, multipartFiles));
    }

    @ApiOperation(value = "Search Product By Key")
    @PostMapping(UrlConstant.Product.DATA_PRODUCT_SEARCH)
    public ResponseEntity<?> searchProducts(@RequestParam("key") String key) {
        return VsResponseUtil.ok(productService.searchProducts(key));
    }

    @ApiOperation(value = "Update Product")
    @PatchMapping(UrlConstant.Product.DATA_PRODUCT_ID)
    public ResponseEntity<?> updateProduct(@PathVariable("id") Long id,
                                           @RequestBody ProductDto productDto,
                                           @RequestParam(name = "img", required = false) List<MultipartFile> multipartFiles) {
        return VsResponseUtil.ok(productService.updateProduct(id, productDto, multipartFiles));
    }

    @ApiOperation(value = "Delete Product By Id Product")
    @DeleteMapping(UrlConstant.Product.DATA_PRODUCT_ID)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(productService.deleteProduct(id));
    }

}

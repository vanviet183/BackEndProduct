package com.hit.product.adapter.web.v1.controllers;

import com.hit.product.adapter.web.base.RestApiV1;
import com.hit.product.adapter.web.base.VsResponseUtil;
import com.hit.product.applications.constants.UrlConstant;
import com.hit.product.applications.services.CartItemService;
import com.hit.product.domains.dtos.BillDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestApiV1
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @GetMapping(UrlConstant.CartItem.DATA_CART_ITEM)
    @ApiOperation(value = "Get All Cart Item In Database")
    public ResponseEntity<?> getCartItems() {
        return VsResponseUtil.ok(cartItemService.getCarts());
    }

    @GetMapping(UrlConstant.CartItem.DATA_CART_ITEM_ID)
    @ApiOperation(value = "Get Cart Item By Id Cart Item")
    public ResponseEntity<?> getCartItemById(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(cartItemService.getCartById(id));
    }

//    @GetMapping(UrlConstant.CartItem.DATA_CART_ITEM_LIST_BY_ID)
//    @ApiOperation(value = "Create Banner")
//    public ResponseEntity<?> getListCartItemById(@RequestParam("id") List<Long> listId) {
//        return VsResponseUtil.ok(cartItemService.getListCartItemById(listId));
//    }

    @PostMapping(UrlConstant.CartItem.DATA_CART_ITEM_ADD_PRODUCT)
    @ApiOperation(value = "Add Product To Cart Of User")
    public ResponseEntity<?> addProductToCart(@PathVariable("idUser") Long idUser,
                                              @PathVariable("idProduct") Long idProduct) {
        return VsResponseUtil.ok(cartItemService.addProductToCart(idUser, idProduct));
    }

    @PostMapping(UrlConstant.CartItem.DATA_CART_ITEM_ID)
    @ApiOperation(value = "Change Amount Of Cart Item In Cart")
    public ResponseEntity<?> changeAmount(@PathVariable("id") Long id, @RequestParam("amount") Integer amount) {
        return VsResponseUtil.ok(cartItemService.changeAmount(id, amount));
    }

    @DeleteMapping(UrlConstant.CartItem.DATA_CART_ITEM_ID)
    @ApiOperation(value = "Delete Cart Item In Cart Of User")
    public ResponseEntity<?> deleteCart(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(cartItemService.deleteCart(id));
    }

}

package com.hit.product.adapter.web.v1.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
  @GetMapping("/")
  @ApiOperation(value = "Check App Run")
  public String app() {
    return "App đã hoạt động";
  }

  @GetMapping("/author")
  @ApiOperation(value = "Slogan Of Shop")
  public String getAuthor() {
    return "Product Hit - Hãy để chúng tôi cùng góp phần trên con đường của bạn :v";
  }

}

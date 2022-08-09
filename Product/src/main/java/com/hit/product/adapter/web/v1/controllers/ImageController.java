package com.hit.product.adapter.web.v1.controllers;

import com.hit.product.adapter.web.base.RestApiV1;
import com.hit.product.adapter.web.base.VsResponseUtil;
import com.hit.product.applications.constants.UrlConstant;
import com.hit.product.applications.services.ImageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestApiV1
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping(UrlConstant.Image.DATA_IMAGE)
    @ApiOperation(value = "Get All Image In Database")
    public ResponseEntity<?> getImages() {
        return VsResponseUtil.ok(imageService.getAll());
    }

    @GetMapping(UrlConstant.Image.DATA_IMAGE_ID)
    @ApiOperation(value = "Get Image By Id Image")
    public ResponseEntity<?> getImage(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(imageService.getImageById(id));
    }

    @PatchMapping(UrlConstant.Image.DATA_IMAGE_ID)
    @ApiOperation(value = "Update Image By Id Image")
    public ResponseEntity<?> updateImage(@PathVariable("id") Long id, @RequestParam("image") MultipartFile multipartFile) {
        return VsResponseUtil.ok(imageService.updateImage(id, multipartFile));
    }

    @DeleteMapping(UrlConstant.Image.DATA_IMAGE_ID)
    @ApiOperation(value = "Delete Image By Id Image")
    public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(imageService.deleteImage(id));
    }


}

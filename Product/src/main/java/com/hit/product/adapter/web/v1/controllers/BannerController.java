package com.hit.product.adapter.web.v1.controllers;

import com.hit.product.adapter.web.base.RestApiV1;
import com.hit.product.adapter.web.base.VsResponseUtil;
import com.hit.product.applications.constants.UrlConstant;
import com.hit.product.applications.services.BannerService;
import com.hit.product.domains.dtos.BannerDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestApiV1
public class BannerController {

    @Autowired
    BannerService bannerService;

    @GetMapping(UrlConstant.Banner.DATA_BANNER)
    @ApiOperation(value = "Get All Banner")
    public ResponseEntity<?> getBanners() {
        return VsResponseUtil.ok(bannerService.getBanners());
    }

    @GetMapping(UrlConstant.Banner.DATA_BANNER_ID)
    @ApiOperation(value = "Get Banner By Id")
    public ResponseEntity<?> getBanner(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(bannerService.getBannerById(id));
    }

    @PostMapping(UrlConstant.Banner.DATA_BANNER_CREATE)
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Create Banner")
    public ResponseEntity<?> createBanner(@RequestBody BannerDto bannerDto, @RequestParam("imgBanner") MultipartFile multipartFile) {
        return VsResponseUtil.ok(bannerService.createBanner(bannerDto, multipartFile));
    }

    @PatchMapping(UrlConstant.Banner.DATA_BANNER_ID)
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Update Banner")
    public ResponseEntity<?> updateBanner(@PathVariable("id") Long id, @RequestBody BannerDto bannerDto, @RequestParam("imgBanner") MultipartFile multipartFile) {
        return VsResponseUtil.ok(bannerService.updateBanner(id, bannerDto, multipartFile));
    }

    @DeleteMapping(UrlConstant.Banner.DATA_BANNER_ID)
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Delete Banner")
    public ResponseEntity<?> deleteBanner(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(bannerService.deleteBanner(id));
    }

}

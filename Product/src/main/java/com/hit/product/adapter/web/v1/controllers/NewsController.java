package com.hit.product.adapter.web.v1.controllers;

import com.hit.product.adapter.web.base.RestApiV1;
import com.hit.product.adapter.web.base.VsResponseUtil;
import com.hit.product.applications.constants.UrlConstant;
import com.hit.product.applications.services.NewsService;
import com.hit.product.domains.dtos.NewsDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestApiV1
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping(UrlConstant.News.DATA_NEWS)
    @ApiOperation(value = "Get All News In Database")
    public ResponseEntity<?> getNews() {
        return VsResponseUtil.ok(newsService.getNews());
    }

    @GetMapping(UrlConstant.News.DATA_NEWS_ID)
    @ApiOperation(value = "Get News By Id News")
    public ResponseEntity<?> getNewsById(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(newsService.getNewsById(id));
    }

    @PostMapping(UrlConstant.News.DATA_NEWS_CREATE)
    @ApiOperation(value = "Create News")
    public ResponseEntity<?> createNews(@ModelAttribute NewsDto newsDto,
                                        @RequestParam("img") List<MultipartFile> multipartFiles) {
        return VsResponseUtil.ok(newsService.createNews(newsDto, multipartFiles));
    }

    @PostMapping(UrlConstant.News.DATA_NEWS_SEARCH)
    @ApiOperation(value = "Search News By Key")
    public ResponseEntity<?> searchNews(@RequestParam("q") String title) {
        return VsResponseUtil.ok(newsService.searchNews(title));
    }

    @PatchMapping(UrlConstant.News.DATA_NEWS_ID)
    @ApiOperation(value = "Update News By Id News")
    public ResponseEntity<?> updateNews(@PathVariable("id") Long id, @RequestBody NewsDto newsDto, @RequestParam("imgNews") List<MultipartFile> multipartFiles) {
        return VsResponseUtil.ok(newsService.updateNews(id, newsDto, multipartFiles));
    }

    @DeleteMapping(UrlConstant.News.DATA_NEWS_ID)
    @ApiOperation(value = "Delete News By Id News")
    public ResponseEntity<?> deleteNews(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(newsService.deleteNews(id));
    }

}

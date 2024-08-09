package com.sample.administration.controller;
import com.sample.administration.dto.UrlMappingRequest;
import com.sample.administration.entity.UrlMapping;
import com.sample.administration.exception.NotFoundException;
import com.sample.administration.service.UrlMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UrlMappingRestController {

    private final UrlMappingService urlMappingService;

    @Autowired
    public UrlMappingRestController(UrlMappingService theUrlMappingService) {
        urlMappingService = theUrlMappingService;
    }

    @GetMapping("/links")
    public List<UrlMapping> findAll() {
        return urlMappingService.findAll();
    }

    @GetMapping("/links/{linkId}")
    public UrlMapping getUrlMapping(@PathVariable int linkId) {

        UrlMapping theLink = urlMappingService.findById(linkId);

        if (theLink == null) {
            throw new NotFoundException("the link id not found - " + linkId);
        }

        return theLink;
    }

    @PostMapping("/add/link")
    public UrlMapping addUrlMapping(@RequestBody UrlMappingRequest urlMapping) {
        return urlMappingService.save(urlMapping.getOriginalLink());
    }


    @DeleteMapping("/links/{linkId}")
    public ResponseEntity<String> deleteUrlMapping(@PathVariable int linkId) {

        UrlMapping urlMapping = urlMappingService.findById(linkId);

        // throw exception if null

        if (urlMapping == null) {
            throw new NotFoundException("the link id not found - " + linkId);
        }

        urlMappingService.deleteById(linkId);

        return new ResponseEntity<>("Deleted the urlmapping id - " + linkId, HttpStatus.OK);
    }

    @GetMapping("/links/paging")
    public Page<UrlMapping> getUrlMappingPaging(
            @RequestParam int page,
            @RequestParam int size) {
        return urlMappingService.findAll(page, size);
    }

}

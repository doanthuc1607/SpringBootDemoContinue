package com.sample.administration.rest;
import com.sample.administration.entity.UrlMapping;
import com.sample.administration.service.UrlMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UrlMappingRestController {

    private UrlMappingService urlMappingService;

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
            throw new RuntimeException("the link id not found - " + linkId);
        }

        return theLink;
    }

    @PostMapping("/links")
    public UrlMapping addUrlMapping(@RequestBody UrlMapping theLink) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theLink.setId(0);

        UrlMapping dbUrlMapping = urlMappingService.save(theLink);

        return dbUrlMapping;
    }


    @PutMapping("/links")
    public UrlMapping updateUrlMapping(@RequestBody UrlMapping theLink) {

        UrlMapping dbUrlMapping = urlMappingService.save(theLink);

        return dbUrlMapping;
    }


    @DeleteMapping("/links/{linkId}")
    public String deleteUrlMapping(@PathVariable int linkId) {

        UrlMapping urlMapping = urlMappingService.findById(linkId);

        // throw exception if null

        if (urlMapping == null) {
            throw new RuntimeException("the link id not found - " + linkId);
        }

        urlMappingService.deleteById(linkId);

        return "Deleted the urlmapping id - " + linkId;
    }

}

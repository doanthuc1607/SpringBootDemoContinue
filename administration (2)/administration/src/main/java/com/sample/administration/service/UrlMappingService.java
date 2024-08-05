package com.sample.administration.service;
import com.sample.administration.entity.UrlMapping;

import java.util.List;

public interface UrlMappingService {

    List<UrlMapping> findAll();

    UrlMapping findById(int theId);

    UrlMapping save(UrlMapping theUrlMapping);

    void deleteById(int theId);

}

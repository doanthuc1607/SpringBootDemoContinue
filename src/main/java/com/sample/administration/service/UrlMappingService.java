package com.sample.administration.service;
import com.sample.administration.entity.UrlMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UrlMappingService {

    List<UrlMapping> findAll();

    UrlMapping findById(int theId);

    UrlMapping save(String originalLink);

    void deleteById(int theId);

    Page<UrlMapping> findAll(int page, int size);



}

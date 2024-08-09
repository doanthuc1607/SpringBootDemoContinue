package com.sample.administration.service.impl;

import com.sample.administration.constants.Constants;
import com.sample.administration.entity.UrlMapping;
import com.sample.administration.exception.NotFoundException;
import com.sample.administration.repository.UrlMappingRepository;
import com.sample.administration.service.UrlMappingService;
import com.sample.administration.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UrlMappingServiceImpl implements UrlMappingService {

    private final UrlMappingRepository urlMappingRepository;

    @Autowired
    public UrlMappingServiceImpl(UrlMappingRepository theUrlMappingRepository) {
        urlMappingRepository = theUrlMappingRepository;
    }

    @Override
    public List<UrlMapping> findAll() {
        return urlMappingRepository.findAll();
    }

    @Override
    public UrlMapping findById(int theId) {
        Optional<UrlMapping> result = urlMappingRepository.findById(theId);

        UrlMapping theLink = null;

        if (result.isPresent()) {
            theLink = result.get();
        }
        else {
            // we didn't find the employee
            throw new NotFoundException("Did not find link id - " + theId);
        }

        return theLink;
    }

    @Transactional
    @Override
    public UrlMapping save(String originalLink) {
        String shortUrl = Util.generateRandomString(Constants.LENGTH_SHORT_URL);
        UrlMapping newLink = new UrlMapping(originalLink, shortUrl);
        return urlMappingRepository.save(newLink);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        urlMappingRepository.deleteById(theId);
    }

    @Override
    public Page<UrlMapping> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return urlMappingRepository.findAll(pageable);
    }
}
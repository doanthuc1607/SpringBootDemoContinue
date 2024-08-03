package com.sample.administration.service.impl;

import com.sample.administration.entity.UrlMapping;
import com.sample.administration.repository.UrlMappingRepository;
import com.sample.administration.service.UrlMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrlMappingServiceImpl implements UrlMappingService {

    private UrlMappingRepository urlMappingRepository;

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
            throw new RuntimeException("Did not find link id - " + theId);
        }

        return theLink;
    }

    @Override
    public UrlMapping save(UrlMapping theLink) {
        return urlMappingRepository.save(theLink);
    }

    @Override
    public void deleteById(int theId) {
        urlMappingRepository.deleteById(theId);
    }
}
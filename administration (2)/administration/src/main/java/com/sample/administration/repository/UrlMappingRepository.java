package com.sample.administration.repository;

import com.sample.administration.entity.UrlMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Integer> {
    Page<UrlMapping> findAll(Pageable pageable);

}

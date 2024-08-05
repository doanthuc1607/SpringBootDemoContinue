package com.sample.administration.repository;

import com.sample.administration.entity.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Integer> {

    // that's it ... no need to write any code!

}

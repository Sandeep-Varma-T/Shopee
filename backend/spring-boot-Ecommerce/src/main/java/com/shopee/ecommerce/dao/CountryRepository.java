package com.shopee.ecommerce.dao;

import com.shopee.ecommerce.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "country", path="countries")
public interface CountryRepository extends JpaRepository<Country,Integer> {
}

package com.iia.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.iia.spring.entity.Product;

/**
 * Repository of the class @see Product
 * @author Antonio Maxime
 *
 */
public interface ProductRepository extends CrudRepository<Product,Long> {

}

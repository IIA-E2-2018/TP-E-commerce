package com.iia.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.iia.spring.entity.Order;

/**
 * Repository of the class @see Order
 * @author Antonio Maxime
 *
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

}

package com.aditya.bootresturantapi.dao;

import com.aditya.bootresturantapi.entities.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Integer> {
    
}

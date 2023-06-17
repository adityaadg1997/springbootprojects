package com.aditya.bootresturantapi.services;

import com.aditya.bootresturantapi.dao.OrderRepository;
import com.aditya.bootresturantapi.entities.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    //save orders to db
    public Orders saveOrder(Orders orders){
        return orderRepository.save(orders);
    }

    //get all orders from db
    public List<Orders> getOrders(){
        return (List<Orders>) orderRepository.findAll();
    }

    //get a specific order by id
    public Optional<Orders> getOrder(int id){
        return orderRepository.findById(id);
    }

    //update a specific order by id
    public Orders updateOrder(int id , Orders order){
         order.setId(id);
         orderRepository.save(order);

         return order;
    }

    //delete order by id
    public void deleteOrder(int id){
        orderRepository.deleteById(id);
    }

}

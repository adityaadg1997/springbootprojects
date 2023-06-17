package com.aditya.bootresturantapi.controllers;

import com.aditya.bootresturantapi.entities.Orders;
import com.aditya.bootresturantapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ResturantController {

    @Autowired
    private OrderService orderService;

    //create order handler
    @PostMapping("/orders")
    public ResponseEntity<Orders> saveOrder(@RequestBody Orders orders){
        try {
            this.orderService.saveOrder(orders);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    //read all orders handler
    @GetMapping("/orders")
    public ResponseEntity<List<Orders>> readAllOrders(){
        List<Orders> ordersList=  orderService.getOrders();
        if (ordersList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(ordersList);
    }

    //read specific order handler
    @GetMapping("/orders/{id}")
    public ResponseEntity<Optional<Orders>> readOrder(@PathVariable("id") int id){
        Optional<Orders> orderById = orderService.getOrder(id);
        if (orderById.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(orderById);
    }

    //update a specific order by id
    @PutMapping("/orders/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable("id") int id,@RequestBody Orders orders){
        try {
            this.orderService.updateOrder(id, orders);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(orders);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    //delete a order by id
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Void> deleteAllOrders(@PathVariable("id") int id){
       try {
           this.orderService.deleteOrder(id);
           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }catch (Exception e){
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }

}

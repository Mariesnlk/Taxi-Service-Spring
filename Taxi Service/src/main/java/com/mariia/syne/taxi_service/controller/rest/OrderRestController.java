package com.mariia.syne.taxi_service.controller.rest;

import com.mariia.syne.taxi_service.model.TaxiOrder;
import com.mariia.syne.taxi_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderRestController {

    /*
    GET     /orders
    GET     /orders/1
    POST    /orders
    PUT     /orders/1
    DELETE  /orders/1
    */

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<TaxiOrder> getAllOrders() {

        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public TaxiOrder getOrder(@PathVariable String id) {

        return orderService.getOrder(id);
    }

    @PostMapping
    public void addOrder(@RequestBody TaxiOrder taxiOrder) {

        orderService.addOrder(taxiOrder);
    }

    @PutMapping("/{id}")
    public void updateOrder(@RequestBody TaxiOrder taxiOrder, @PathVariable String id) {

        orderService.updateOrder(taxiOrder, id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable String id) {

        orderService.deleteOrder(id);
    }

//    @GetMapping("/init")
//    public void generateOrders() {
//
//        orderService.initTable();
//    }
}


package com.mariia.syne.taxi_service.service;

import com.mariia.syne.taxi_service.model.TaxiOrder;
import com.mariia.syne.taxi_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;


    public List<TaxiOrder> getAllOrders(){

        List<TaxiOrder> taxiOrders = new ArrayList<>();
        orderRepository.findAll().forEach(taxiOrders::add);
        return taxiOrders;
    }

    public TaxiOrder getOrder(Integer id){
        return orderRepository.findById(id).orElse(null);
    }

    public void addOrder(TaxiOrder taxiOrder){

        orderRepository.save(taxiOrder);
    }

    public void updateOrder(TaxiOrder taxiOrder, Integer id){

        orderRepository.save(taxiOrder);
    }

    public void deleteOrder(Integer id){
        orderRepository.deleteById(id);
    }
}

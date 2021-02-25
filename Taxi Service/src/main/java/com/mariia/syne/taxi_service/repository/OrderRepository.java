package com.mariia.syne.taxi_service.repository;

import com.mariia.syne.taxi_service.model.TaxiOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TaxiOrder, Integer> {
}

package com.mariia.syne.taxi_service.repository;

import com.mariia.syne.taxi_service.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

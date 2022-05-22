package com.example.models.repos;

import java.util.List;

import com.example.models.entities.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer,Long>{
    List<Customer> findByNameContains(String name);
}

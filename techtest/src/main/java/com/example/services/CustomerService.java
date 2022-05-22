package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.models.entities.Customer;
import com.example.models.repos.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {
    
    @Autowired
    private CustomerRepo customerRepo;

    public Customer save(Customer customer){
        return customerRepo.save(customer);
    }

    public Customer findOne(Long id){
        Optional<Customer> customer=customerRepo.findById(id);
        if(!customer.isPresent()){
            return null;
        }
        return customer.get();
    }

    public Iterable<Customer> findAll(){
        return customerRepo.findAll();
    }

    public String removeOne(Long id){
        customerRepo.deleteById(id);
        return "Removed succesfully";
    }

    public List<Customer> findByName(String name){
        return customerRepo.findByNameContains(name);
    }
}

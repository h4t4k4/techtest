package com.example.controllers;

import javax.validation.Valid;

import com.example.dto.ResponseData;
import com.example.models.entities.Customer;
import com.example.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<ResponseData<Customer>> create(@Valid @RequestBody Customer customer,Errors errors){
        ResponseData<Customer> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            // for(ObjectError error : errors.getAllErrors()){
            //     responseData.getMessages().add(error.getDefaultMessage());
            // }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(customerService.save(customer));
        return ResponseEntity.ok(responseData);
    } 


    @GetMapping
    public Iterable<Customer> getAll(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer findOne(@PathVariable("id") Long id){
        return customerService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Customer>> update(@Valid @RequestBody Customer customer,Errors errors){
        ResponseData<Customer> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            // for(ObjectError error : errors.getAllErrors()){
            //     responseData.getMessages().add(error.getDefaultMessage());
            // }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(customerService.save(customer));
        return ResponseEntity.ok(responseData);
    } 

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        return customerService.removeOne(id);
    }
}

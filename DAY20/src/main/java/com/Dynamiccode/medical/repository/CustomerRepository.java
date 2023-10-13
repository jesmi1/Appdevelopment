package com.Dynamiccode.medical.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dynamiccode.medical.model.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByCustomerName(String customerName);

    Customer findByCid(Long cid);

    void deleteByCid(Long cid);

}

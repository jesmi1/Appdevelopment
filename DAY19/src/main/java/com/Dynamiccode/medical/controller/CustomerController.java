package com.Dynamiccode.medical.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Dynamiccode.medical.constant.Api;
import com.Dynamiccode.medical.dto.request.CustomerRequest;
import com.Dynamiccode.medical.dto.response.CustomerResponse;
import com.Dynamiccode.medical.service.CustomerService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Api.CUSTOMER)
@RequiredArgsConstructor
@Tag(name = "Customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerRequest request) {
        boolean isSaved = customerService.saveCustomer(request);
        return isSaved ? ResponseEntity.status(201).body("Customer added successfully!")
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        List<CustomerResponse> customerList = customerService.getAllCustomers();
        return !customerList.isEmpty() ? ResponseEntity.status(200).body(customerList)
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/{cid}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Long cid) {
        CustomerResponse customerResponse = customerService.getCustomer(cid);
        return customerResponse != null ? ResponseEntity.ok().body(customerResponse) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{cid}")
    public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody CustomerRequest request, @PathVariable Long cid) {
        CustomerResponse customerResponse = customerService.updateCustomer(request, cid);
        return customerResponse != null ? ResponseEntity.ok().body(customerResponse) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{cid}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long cid) {
        boolean isDeleted = customerService.deleteCustomer(cid);
        return isDeleted ? ResponseEntity.ok().body("Customer deleted successfully!")
                : ResponseEntity.notFound().build();
    }

}

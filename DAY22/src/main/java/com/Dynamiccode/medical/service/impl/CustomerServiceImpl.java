package com.Dynamiccode.medical.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Dynamiccode.medical.dto.request.CustomerRequest;
import com.Dynamiccode.medical.dto.response.CustomerResponse;
import com.Dynamiccode.medical.model.Customer;
import com.Dynamiccode.medical.repository.CustomerRepository;
import com.Dynamiccode.medical.service.CustomerService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public boolean saveCustomer(CustomerRequest request) {
        if (customerRepository.findByCustomerName(request.getCustomerName()).isPresent()) {
            return false;
        }

        Customer customer = Customer.builder()
                .customerName(request.getCustomerName())
                .customerSalary(request.getCustomerSalary())
                .applianceOrdered(request.getApplianceOrdered())
                .brandName(request.getBrandName())
                .applianceName(request.getApplianceName())
                .build();

        customerRepository.save(customer);
        return true;
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();

        return customerList.stream()
                .map(this::mapCustomerToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponse getCustomer(Long cid) {
        Customer customer = customerRepository.findByCid(cid);
        return mapCustomerToResponse(customer);
    }

    @Override
    public CustomerResponse updateCustomer(CustomerRequest request, Long cid) {
        Customer customer = customerRepository.findByCid(cid);

        if (customer != null) {
            customer.setCustomerName(request.getCustomerName());
            customer.setCustomerSalary(request.getCustomerSalary());
            customer.setApplianceOrdered(request.getApplianceOrdered());
            customer.setBrandName(request.getBrandName());
            customer.setApplianceName(request.getApplianceName());

            customerRepository.save(customer);

            return mapCustomerToResponse(customer);
        } else {
            throw new EntityNotFoundException("Customer with cid " + cid + " not found");
        }
    }

    @Override
    public boolean deleteCustomer(Long cid) {
        Customer customer = customerRepository.findByCid(cid);

        if (customer != null) {
            customerRepository.deleteByCid(cid);
            return true;
        } else {
            return false;
        }
    }

    private CustomerResponse mapCustomerToResponse(Customer customer) {
        return CustomerResponse.builder()
                .cid(customer.getCid())
                .customerName(customer.getCustomerName())
                .customerSalary(customer.getCustomerSalary())
                .applianceOrdered(customer.getApplianceOrdered())
                .brandName(customer.getBrandName())
                .applianceName(customer.getApplianceName())
                .build();
    }

    @Override
    public Customer getCustomerModelId(Long cid) {
        return customerRepository.findByCid(cid);
    }
}

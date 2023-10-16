package com.Dynamiccode.medical.service;

import java.util.List;

import com.Dynamiccode.medical.dto.request.CustomerRequest;
import com.Dynamiccode.medical.dto.response.CustomerResponse;
import com.Dynamiccode.medical.model.Customer;

public interface CustomerService {

    boolean saveCustomer(CustomerRequest request);

    List<CustomerResponse> getAllCustomers();

    CustomerResponse getCustomer(Long cid);

    CustomerResponse updateCustomer(CustomerRequest request, Long cid);

    boolean deleteCustomer(Long cid);

    Customer getCustomerModelId(Long cid);

}

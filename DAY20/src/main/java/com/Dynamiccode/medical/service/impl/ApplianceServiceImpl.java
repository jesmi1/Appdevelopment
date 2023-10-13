package com.Dynamiccode.medical.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dynamiccode.medical.dto.info.CustomerInfo;
import com.Dynamiccode.medical.dto.request.ApplianceRequest;
import com.Dynamiccode.medical.model.Customer;
import com.Dynamiccode.medical.model.Appliance;
import com.Dynamiccode.medical.model.ApplianceMapping;
import com.Dynamiccode.medical.model.User;
import com.Dynamiccode.medical.repository.CustomerRepository;
import com.Dynamiccode.medical.repository.ApplianceRepository;
import com.Dynamiccode.medical.repository.UserRepository;
import com.Dynamiccode.medical.service.CustomerService;
import com.Dynamiccode.medical.service.ApplianceService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplianceServiceImpl implements ApplianceService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final ApplianceRepository applianceRepository;
    private final CustomerService customerService;

    @Override
    public boolean saveAppliance(ApplianceRequest request) {
        User user = userRepository.findByUid(request.getUid());
        List<CustomerInfo> customerInfoList = request.getCustomers();
        long appointTime = calculateappointTime(customerInfoList);

        if (appointTime <= 0) {
            throw new IllegalArgumentException("Patient appointTime must be greater than zero.");
        }

        try {
            Appliance appliance = createAppliance(request, user, appointTime, customerInfoList);
            applianceRepository.save(appliance);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Appliance createAppliance(ApplianceRequest request, User user, long appointTime, List<CustomerInfo> customerInfoList) {
        Appliance appliance = Appliance.builder()
                .appointDate(new Date())
                .patAddress(request.getPatAddress())
                .paymentMode(request.getPaymentMode())
                .user(user)
                .appointTime(appointTime)
                .applianceMappings(request.getCustomers().stream()
                        .map(customerRequest -> {
                            Customer customer = customerService.getCustomerModelId(customerRequest.getCid());
                            if (customer != null) {
                                return ApplianceMapping.builder().customer(customer).build();
                            } else {
                                throw new IllegalArgumentException("Invalid customer ID: " + customerRequest.getCid());
                            }
                        })
                        .collect(Collectors.toList()))
                .build();

        updateCustomerQuantities(customerInfoList);

        return appliance;
    }

    private List<Customer> updateCustomerQuantities(List<CustomerInfo> customerInfoList) {
        List<Customer> updatedCustomers = new ArrayList<>();

        for (CustomerInfo customerInfo : customerInfoList) {
            Long customerId = customerInfo.getCid();
            Long applianceOrdered = customerInfo.getApplianceOrdered();

            Customer customer = getCustomerOrThrow(customerId);

            if (customer.getApplianceOrdered() < applianceOrdered) {
                throw new IllegalArgumentException("Insufficient yearsofExp for customer ID: " + customerId);
            }

            Customer updatedCustomer = createUpdatedCustomer(customer, applianceOrdered);
            customerRepository.save(updatedCustomer);
            updatedCustomers.add(updatedCustomer);
        }

        return updatedCustomers;
    }

    private Customer getCustomerOrThrow(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found for ID: " + customerId));
    }

    private Customer createUpdatedCustomer(Customer customer, Long applianceOrdered) {
        Customer updatedCustomer = new Customer();
        updatedCustomer.setCid(customer.getCid());
        updatedCustomer.setCustomerName(customer.getCustomerName());
        updatedCustomer.setCustomerSalary(customer.getCustomerSalary());
        updatedCustomer.setApplianceOrdered(customer.getApplianceOrdered() - applianceOrdered);
        updatedCustomer.setBrandName(customer.getBrandName());
        updatedCustomer.setApplianceName(customer.getApplianceName());
        return updatedCustomer;
    }

    private long calculateappointTime(List<CustomerInfo> customerInfoList) {
        return customerInfoList.stream()
                .mapToLong(customerInfo -> {
                    Customer customer = getCustomerOrThrow(customerInfo.getCid());
                    if (customer.getApplianceOrdered() < customerInfo.getApplianceOrdered()) {
                        throw new IllegalArgumentException(
                                "Insufficient applianceOrdered for customer ID: " + customerInfo.getCid());
                    }
                    return (long) (customer.getCustomerSalary() * customerInfo.getApplianceOrdered());
                })
                .sum();
    }
}

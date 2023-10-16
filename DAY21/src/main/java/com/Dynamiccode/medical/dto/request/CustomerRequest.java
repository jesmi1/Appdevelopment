package com.Dynamiccode.medical.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String customerName;
    private float customerSalary;
    private Long applianceOrdered;
    private String brandName;
    private String applianceName;
}

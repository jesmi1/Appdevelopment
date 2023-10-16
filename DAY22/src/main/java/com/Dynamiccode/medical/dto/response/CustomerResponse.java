package com.Dynamiccode.medical.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private Long cid;
    private String customerName;
    private float customerSalary;
    private Long applianceOrdered;
    private String brandName;
    private String applianceName;
}

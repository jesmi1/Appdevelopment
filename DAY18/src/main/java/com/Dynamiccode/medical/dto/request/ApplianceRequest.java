package com.Dynamiccode.medical.dto.request;

import java.util.List;

import com.Dynamiccode.medical.dto.info.CustomerInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplianceRequest {
    private String patAddress;
    private String paymentMode;
    private Long uid;
    private List<CustomerInfo> customers;
}

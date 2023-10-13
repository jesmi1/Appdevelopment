package com.Dynamiccode.medical.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_cust")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Column(length = 250, nullable = false)
    private String customerName;

    @Column(nullable = false)
    private float customerSalary;

    @Column(nullable = false)
    private Long applianceOrdered;

    @Column(nullable = false)
    private String brandName;

    @Column(length = 50000, nullable = true)
    private String applianceName;
}

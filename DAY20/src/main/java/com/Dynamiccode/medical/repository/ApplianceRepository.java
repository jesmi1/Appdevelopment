package com.Dynamiccode.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dynamiccode.medical.model.Appliance;

public interface ApplianceRepository extends JpaRepository<Appliance, Long> {

    void deleteByUserUid(Long uid);

}

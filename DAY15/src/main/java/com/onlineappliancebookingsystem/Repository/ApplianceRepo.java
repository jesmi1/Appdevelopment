package com.onlineappliancebookingsystem.Repository;


	import org.springframework.data.repository.CrudRepository;

import com.onlineappliancebookingsystem.Model.ApplianceModel;

import java.util.List;

	public interface ApplianceRepo extends CrudRepository<ApplianceModel, Integer>
	{

		boolean existsByApplianceNameIgnoreCase(String applianceName);

	    List<ApplianceModel> findByApplianceNameContainingIgnoreCase(String applianceName);
	}

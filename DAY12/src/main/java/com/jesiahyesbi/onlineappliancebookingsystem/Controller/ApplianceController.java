package com.jesiahyesbi.onlineappliancebookingsystem.Controller;
 import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jesiahyesbi.onlineappliancebookingsystem.Model.ApplianceModel;
import com.jesiahyesbi.onlineappliancebookingsystem.Serviceint.ApplianceService;
@RestController
@RequestMapping(value="/appliance")
@CrossOrigin("*")
public class ApplianceController{
	@Autowired
	private ApplianceService applianceService;
	
	@GetMapping(value="/getall")
	private ResponseEntity<Object> getAppliances() 
	{
		List<ApplianceModel> applianceList = applianceService.getAppliances();
		return new ResponseEntity<>(applianceList, HttpStatus.OK);
	}

	@GetMapping(value="/getbyid/{applianceId}")
	private ResponseEntity<Object> getAppliancebyid(@PathVariable int applianceId) 
	{
		boolean isApplianceExistbyid = applianceService.isApplianceExistbyid(applianceId);
		if (isApplianceExistbyid)
		{
		ApplianceModel applianceModel = applianceService.getAppliancebyid(applianceId);
		return new ResponseEntity<>(applianceModel, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("ID not found",HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/getbyname/{applianceName}")
	private ResponseEntity<Object> getAppliancebyname(@PathVariable String applianceName) 
	{
		List<ApplianceModel> applianceModel = applianceService.getAppliancebyname(applianceName);
		return new ResponseEntity<>(applianceModel, HttpStatus.OK);
	}
	
	
	
	
	@PostMapping(value="/add")
	public String createAppliance(@RequestBody ApplianceModel applianceModel)
	{
		boolean isApplianceExist = applianceService.isApplianceExist(applianceModel.getApplianceName());
		if(isApplianceExist)
			return "Appliance exists already";
		else {
		applianceModel = applianceService.createAppliance(applianceModel);
		return "Appliance added";}
	}
		
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<Object> deleteAppliance(@RequestParam int applianceId)
	{
			applianceService.deleteAppliance(applianceId);
			return new ResponseEntity<>("R.I.P."
					+ "\nCause of Death : DoctorPageModel Deletion", HttpStatus.OK);
	}
	
	
	@PutMapping(value="/edit/{applianceId}")
	public ResponseEntity<Object> updateAppliance(@PathVariable int applianceId, @RequestBody ApplianceModel applianceModel)
	{
			applianceModel.setApplianceId(applianceId);
			applianceService.updateAppliance(applianceModel);
			return new ResponseEntity<>("AppliancePageModel details are updated successsfully !", HttpStatus.OK);
	}
	
}
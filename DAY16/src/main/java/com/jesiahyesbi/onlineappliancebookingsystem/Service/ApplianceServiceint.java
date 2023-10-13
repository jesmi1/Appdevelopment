package com.jesiahyesbi.onlineappliancebookingsystem.Service;

	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.jesiahyesbi.onlineappliancebookingsystem.Model.ApplianceModel;
	import com.jesiahyesbi.onlineappliancebookingsystem.Repository.ApplianceRepo;
	import com.jesiahyesbi.onlineappliancebookingsystem.Serviceint.ApplianceService;

	@Service
	public class ApplianceServiceint implements ApplianceService{
		
		@Autowired
		private ApplianceRepo applianceRepo;

		@Override
		public List<ApplianceModel> getAppliances() {
			return (List<ApplianceModel>)applianceRepo.findAll();
		}

		@Override
		public ApplianceModel createAppliance(ApplianceModel applianceModel) {
			return applianceRepo.save(applianceModel);
		}

		@Override
		public void deleteAppliance(Integer applianceId) {
			applianceRepo.deleteById(applianceId);
		}

		@Override
		public void updateAppliance(ApplianceModel applianceModel) {
			applianceRepo.save(applianceModel);
		}

		@Override
		public boolean isApplianceExist(String applianceName) {
			return applianceRepo.existsByApplianceNameIgnoreCase(applianceName);
		}

		@Override
		public boolean isApplianceExistbyid(int applianceId) {
			return applianceRepo.existsById(applianceId);
		}

		@Override
		public ApplianceModel getAppliancebyid(int applianceId) {
			Optional<ApplianceModel> optional = applianceRepo.findById(applianceId);
			ApplianceModel applianceModel = optional.get();
			return applianceModel;
		}
		
		@Override
		public List<ApplianceModel> getAppliancebyname(String applianceName) 
		{
			return (List<ApplianceModel>) applianceRepo.findByApplianceNameContainingIgnoreCase(applianceName);
		}
		
	}
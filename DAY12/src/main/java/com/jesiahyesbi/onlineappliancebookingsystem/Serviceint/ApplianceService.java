package com.jesiahyesbi.onlineappliancebookingsystem.Serviceint;


	import java.util.List;

	import com.jesiahyesbi.onlineappliancebookingsystem.Model.ApplianceModel;

	public interface ApplianceService{

		public abstract List<ApplianceModel> getAppliances();

		public abstract ApplianceModel createAppliance(ApplianceModel applianceModel);

		public abstract void updateAppliance(ApplianceModel applianceModel);

		public abstract void deleteAppliance(Integer applianceId);

		public abstract boolean isApplianceExist(String applianceName);

		public abstract boolean isApplianceExistbyid(int applianceId);

	    public abstract ApplianceModel getAppliancebyid(int applianceId);

	    public abstract List<ApplianceModel> getAppliancebyname(String applianceName);
		
	}


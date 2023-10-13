package com.jesiahyesbi.onlineappliancebookingsystem.Model;


	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	@Entity
	@Table(name="watch1")
	public class ApplianceModel{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int applianceId;
		private String applianceName;
		
		private String custName;
		private String appliancedept;
	    
		

		public int getApplianceId() {
			return applianceId;
		}



		public void setApplianceId(int applianceId) {
			this.applianceId = applianceId;
		}



		public String getApplianceName() {
			return applianceName;
		}



		public void setApplianceName(String applianceName) {
			this.applianceName = applianceName;
		}



		public String getCustName() {
			return custName;
		}



		public void setCustName(String custName) {
			this.custName = custName;
		}



		public String getAppliancedept() {
			return appliancedept;
		}



		public void setAppliancedept(String appliancedept) {
			this.appliancedept = appliancedept;
		}

	    

		public ApplianceModel(int applianceId, String applianceName, String custName, String appliancedept) {
			super();
			this.applianceId = applianceId;
			this.applianceName = applianceName;
			this.custName = custName;
			this.appliancedept = appliancedept;
		}



		public ApplianceModel()
		{
			
		}
	}



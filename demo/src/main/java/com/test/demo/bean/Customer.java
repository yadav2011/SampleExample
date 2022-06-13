package com.test.demo.bean;

public class Customer {
	
	private Long customerId;
	private Long contractId;
	private String geozone;
	private String teamcode;
	private String projectcode;
	private Long buildduration;
	
	public Customer() {
		
	}
	
	public Customer(Long customerId, Long contractId, String geozone, String teamcode, String projectcode,
			Long buildduration) {
		super();
		this.customerId = customerId;
		this.contractId = contractId;
		this.geozone = geozone;
		this.teamcode = teamcode;
		this.projectcode = projectcode;
		this.buildduration = buildduration;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getContractId() {
		return contractId;
	}
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	public String getGeozone() {
		return geozone;
	}
	public void setGeozone(String geozone) {
		this.geozone = geozone;
	}
	public String getTeamcode() {
		return teamcode;
	}
	public void setTeamcode(String teamcode) {
		this.teamcode = teamcode;
	}
	public String getProjectcode() {
		return projectcode;
	}
	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}
	public Long getBuildduration() {
		return buildduration;
	}
	public void setBuildduration(Long buildduration) {
		this.buildduration = buildduration;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", contractId=" + contractId + ", geozone=" + geozone
				+ ", teamcode=" + teamcode + ", projectcode=" + projectcode + ", buildduration=" + buildduration + "]";
	}
	
	

}

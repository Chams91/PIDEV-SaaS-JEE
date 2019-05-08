package DTO;

import java.io.Serializable;

public class CompanyDTO implements Serializable{

	private int CompanyId;
	private String Name;
	private String LogoUrl;
	
	public CompanyDTO() {
		super();
	}
	
	public int getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId(int companyId) {
		CompanyId = companyId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLogoUrl() {
		return LogoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		LogoUrl = logoUrl;
	}
	
	
	
	
	
	
}

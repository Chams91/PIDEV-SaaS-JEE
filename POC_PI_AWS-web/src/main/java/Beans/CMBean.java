package Beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import DTO.CompanyDTO;
import services.CMConsume;

@ManagedBean
public class CMBean {
	
	@EJB
	CMConsume chamsService;

	private List<CompanyDTO> companies;
	
	public List<CompanyDTO> getCompanies(){
		companies= chamsService.ConsumeCompanyList();
		return companies;
	}
}

package Beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import DTO.CompanyDTO;
import DTO.UserDTO;
import services.CMConsume;

@ManagedBean
public class CMBean {
	
	@EJB
	CMConsume chamsService;

	private List<CompanyDTO> companies;
	private List<UserDTO> users;
	
	public List<CompanyDTO> getCompanies(){
		companies= chamsService.ConsumeCompanyList();
		return companies;
	}
	
	public List<UserDTO> getUsers(){
		users = chamsService.ConsumeUserList();
		return users;
	}
}

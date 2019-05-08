package Beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import DTO.CompanyDTO;
import DTO.UserDTO;
import services.CMConsume;

@ManagedBean
public class CMBean {
	
	private String nom;
	private String Logo;
	
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
	
	
	public String CreateCompany () {
		chamsService.CompanyCreate(new CompanyDTO(nom, Logo));
		return "/CompanyList?faces-redirect=true";
	}
	
	public String DeleteCompany(int id) {
		chamsService.CompanyDelete(id);
		return "/CompanyList?faces-redirect=true";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogo() {
		return Logo;
	}

	public void setLogo(String logo) {
		Logo = logo;
	}
	
	
	
}

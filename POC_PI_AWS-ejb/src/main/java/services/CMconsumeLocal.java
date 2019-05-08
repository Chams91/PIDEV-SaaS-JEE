package services;

import java.util.List;

import javax.ejb.Local;

import DTO.CompanyDTO;
import DTO.UserDTO;

@Local
public interface CMconsumeLocal {

	List<CompanyDTO> ConsumeCompanyList();

	List<UserDTO> ConsumeUserList();
	
	
	void CompanyCreate(CompanyDTO c);
	
	void CompanyDelete (int id);
	
}

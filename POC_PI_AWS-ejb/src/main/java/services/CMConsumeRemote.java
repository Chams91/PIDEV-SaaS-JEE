package services;

import java.util.List;

import javax.ejb.Remote;

import DTO.CompanyDTO;
import DTO.UserDTO;

@Remote
public interface CMConsumeRemote {

	List<CompanyDTO> ConsumeCompanyList();
	List<UserDTO> ConsumeUserList();
	
	void CompanyCreate(CompanyDTO c);
	
	void CompanyDelete (int id);
}

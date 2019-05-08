package services;

import java.util.List;

import javax.ejb.Remote;

import DTO.CompanyDTO;

@Remote
public interface CMConsumeRemote {

	List<CompanyDTO> ConsumeCompanyList();
	void ConsumeUserList();
}

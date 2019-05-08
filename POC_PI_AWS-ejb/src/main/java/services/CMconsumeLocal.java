package services;

import java.util.List;

import javax.ejb.Local;

import DTO.CompanyDTO;

@Local
public interface CMconsumeLocal {

	List<CompanyDTO> ConsumeCompanyList();

	void ConsumeUserList();
	
	
}

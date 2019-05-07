package services;

import javax.ejb.Local;

@Local
public interface CMconsumeLocal {

	void ConsumeCompanyList();

	void ConsumeUserList();
	
	
}

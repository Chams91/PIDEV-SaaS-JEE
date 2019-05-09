package tn.esprit.imputation.service.interf;

import java.util.List;


import tn.esprit.imputation.entity.Project;

public interface ProjectServiceLocal {

	List<Project> Consommation();
	void postRequest(Project p);
	//void Consommationbyid(int id);
	void DelRequest(int id);
	void putRequest(int id, Project p);
}

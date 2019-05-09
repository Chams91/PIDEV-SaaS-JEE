package tn.esprit.imputation.service.interf;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.imputation.entity.Project;
@Remote
public interface ProjectServiceRemote {
	
	List<Project> Consommation();
	void postRequest(Project p);
	//void Consommationbyid(int id);
	void DelRequest(int id);
	void putRequest(int id, Project p);
	
}



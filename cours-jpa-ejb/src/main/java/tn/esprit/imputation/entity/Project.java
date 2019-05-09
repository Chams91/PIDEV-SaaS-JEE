package tn.esprit.imputation.entity;
import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable{
	 
	public int ProjectId ;
	public String Name ;	       
	public String DateBegin ;
	public String DateEnd;
	public String Description ;
	public int Etat ;
	public int TotalNbrRessources ;
	public Project()
    {
    	super();
    }
	
	public int getProjectId() {
		return ProjectId;
	}
	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDateBegin() {
		return DateBegin;
	}
	public void setDateBegin(String dateBegin) {
		DateBegin = dateBegin;
	}
	public String getDateEnd() {
		return DateEnd;
	}
	public void setDateEnd(String dateEnd) {
		DateEnd = dateEnd;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getEtat() {
		return Etat;
	}
	public void setEtat(int etat) {
		Etat = etat;
	}
	public int getTotalNbrRessources() {
		return TotalNbrRessources;
	}
	public void setTotalNbrRessources(int totalNbrRessources) {
		TotalNbrRessources = totalNbrRessources;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Project [ProjectId=" + ProjectId + ", Name=" + Name + ", DateBegin=" + DateBegin + ", DateEnd="
				+ DateEnd + ", Description=" + Description + ", Etat=" + Etat + ", TotalNbrRessources="
				+ TotalNbrRessources + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DateBegin == null) ? 0 : DateBegin.hashCode());
		result = prime * result + ((DateEnd == null) ? 0 : DateEnd.hashCode());
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + Etat;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ProjectId;
		result = prime * result + TotalNbrRessources;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (DateBegin == null) {
			if (other.DateBegin != null)
				return false;
		} else if (!DateBegin.equals(other.DateBegin))
			return false;
		if (DateEnd == null) {
			if (other.DateEnd != null)
				return false;
		} else if (!DateEnd.equals(other.DateEnd))
			return false;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (Etat != other.Etat)
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (ProjectId != other.ProjectId)
			return false;
		if (TotalNbrRessources != other.TotalNbrRessources)
			return false;
		return true;
	}

	public Project(int projectId, String name, String dateBegin, String dateEnd, int totalNbrRessources , String description, int etat
			) {
		super();
		ProjectId = projectId;
		Name = name;
		DateBegin = dateBegin;
		DateEnd = dateEnd;
		TotalNbrRessources = totalNbrRessources;
		Description = description;
		Etat = etat;
		
	}
	public Project(String name, String dateBegin, String dateEnd,int totalNbrRessources, String description, 
			int etat) {
		super();
		Name = name;
		DateBegin = dateBegin;
		DateEnd = dateEnd;
		TotalNbrRessources = totalNbrRessources;
		Description = description;
		Etat=etat;
	}

	

}

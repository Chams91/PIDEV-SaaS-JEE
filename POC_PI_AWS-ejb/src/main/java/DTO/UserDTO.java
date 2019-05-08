package DTO;

import java.io.Serializable;

public class UserDTO implements Serializable

{

	//chams entity
	
	/*
	 * private String FirstName;
	private String LastName;
	private String Email;
	private String Password;
	*/
	
	private int CompanyId;
	/*private String UserName;
	*/
	
	/*
	public UserDTO() {
		super();
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}*/
	public int getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId(int companyId) {
		CompanyId = companyId;
	}
	/*public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	*/
	
	
}

package services;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import DTO.CompanyDTO;
import DTO.UserDTO;

@Stateless
@LocalBean
public class CMConsume implements CMconsumeLocal, CMConsumeRemote{

	@Override
	public List<CompanyDTO> ConsumeCompanyList() {
		// TODO Auto-generated method stub
		List<CompanyDTO> LC = new ArrayList<CompanyDTO> ();
		Client client = ClientBuilder.newClient();
		WebTarget web = client.target("http://dotnet-env.brdcijzrz7.eu-west-1.elasticbeanstalk.com/api/CompanyAPI");
		
        Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	
    	for (int i=0;i<object.size();i++)
    	{
    		CompanyDTO c =new CompanyDTO();
    		c.setCompanyId(object.getJsonObject(i).getInt("CompanyId"));
    		c.setName(object.getJsonObject(i).getString("Name"));
    		LC.add(c);
    		
    		
    	}
    	
    	return LC;
    	
    	//System.out.println(result);
	}
	
	
	

	public List<UserDTO> ConsumeUserList() {
		// TODO Auto-generated method stub
		

		List<UserDTO> LU = new ArrayList<UserDTO> ();
		
		Client client2 = ClientBuilder.newClient();
		WebTarget web2 = client2.target("http://localhost:2212/api/UserAPI");
		
        Response response2 = web2.request().get();
    	
    	String result2 = response2.readEntity(String.class); 
    	JsonReader jsonReader2 = Json.createReader(new StringReader(result2));
    	JsonArray object2 =  jsonReader2.readArray();
    	
    	for (int i=0;i<object2.size();i++)
    	{
    		UserDTO user =new UserDTO();
    		
    		/*user.setFirstName(object.getJsonObject(i).getString("FirstName"));
    		user.setLastName(object.getJsonObject(i).getString("LastName"));*/
    		user.setCompanyId(object2.getJsonObject(i).getInt("CompanyId"));
    		/*
    		user.setEmail(object.getJsonObject(i).getString("Email"));
    		c.setCompanyId(object.getJsonObject(i).getInt("CompanyId"));
    		c.setEmail(object.getJsonObject(i).getString("Email"));
    		c.setFirstName(object.getJsonObject(i).getString("FirstName"));
    		c.setLastName(object.getJsonObject(i).getString("LastName"));
    		c.setPassword(object.getJsonObject(i).getString("Password"));*/
    		
    		LU.add(user);
    		
    		
    	}
    	
    	return LU;
    	
    	//System.out.println(result2);
	}




	@Override
	public void CompanyCreate(CompanyDTO c) {
		// TODO Auto-generated method stub
		
		
		CompanyDTO company = new CompanyDTO();
		company.setName(c.getName());
		company.setLogoUrl(c.getLogoUrl());
		
		
		Client client3 = ClientBuilder.newClient();
		WebTarget web3 = client3.target("http://dotnet-env.brdcijzrz7.eu-west-1.elasticbeanstalk.com/api/CompanyCreate");
		
		WebTarget hello = web3.path("");
		
		Response response = hello.request().post(Entity.entity(c, MediaType.APPLICATION_JSON));
		
		String result = response.readEntity(String.class);
		System.out.println(result);
		response.close();
	}
	
	@Override
	public void CompanyUpdate(int id, CompanyDTO c) {
		// TODO Auto-generated method stub
		
		
		CompanyDTO company = new CompanyDTO();
		company.setName(c.getName());
		company.setLogoUrl(c.getLogoUrl());
		
		
		Client client3 = ClientBuilder.newClient();
		WebTarget web3 = client3.target("http://dotnet-env.brdcijzrz7.eu-west-1.elasticbeanstalk.com/api/CompanyUpdate/"+id);
		
		WebTarget hello = web3.path("");
		
		Response response = hello.request().put(Entity.entity(c, MediaType.APPLICATION_JSON));
		
		response.close();
	}

	



	@Override
	public void CompanyDelete(int id) {
		// TODO Auto-generated method stub
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://dotnet-env.brdcijzrz7.eu-west-1.elasticbeanstalk.com/api/CompanyDelete/"+id);
		WebTarget hello =target.path("");
		Response response =hello.request(MediaType.APPLICATION_JSON_TYPE, MediaType.TEXT_PLAIN_TYPE).delete();
		response.close();
		
		
	}



	 
}

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
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import DTO.CompanyDTO;

@Stateless
@LocalBean
public class CMConsume implements CMconsumeLocal, CMConsumeRemote{

	@Override
	public List<CompanyDTO> ConsumeCompanyList() {
		// TODO Auto-generated method stub
		List<CompanyDTO> LC = new ArrayList<CompanyDTO> ();
		Client client = ClientBuilder.newClient();
		WebTarget web = client.target("http://localhost:2212/api/CompanyAPI");
		
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

	public void ConsumeUserList() {
		// TODO Auto-generated method stub
		

		Client client2 = ClientBuilder.newClient();
		WebTarget web2 = client2.target("http://localhost:2212/api/UserAPI");
		
        Response response2 = web2.request().get();
    	
    	String result2 = response2.readEntity(String.class); 
    	
    	System.out.println(result2);
	}



	 
}
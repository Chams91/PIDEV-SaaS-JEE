package services;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateless
public class CMConsume implements CMconsumeLocal, CMConsumeRemote{

	@Override
	public void ConsumeCompanyList() {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		WebTarget web = client.target("http://localhost:2212/api/CompanyAPI");
		
        Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	System.out.println(result);
	}

	 
}

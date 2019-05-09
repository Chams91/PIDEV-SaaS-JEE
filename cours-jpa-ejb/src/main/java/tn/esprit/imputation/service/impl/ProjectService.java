package tn.esprit.imputation.service.impl;
import java.io.StringReader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import tn.esprit.imputation.entity.Project;
import tn.esprit.imputation.service.interf.ProjectServiceLocal;
import tn.esprit.imputation.service.interf.ProjectServiceRemote;

/**
 * Session Bean implementation class DemandeurConsom
 * @param <Project>
 */
@Stateful
@LocalBean
public class ProjectService implements ProjectServiceRemote,ProjectServiceLocal
{

	@Override
	public List<Project> Consommation() {
		List<Project>  lasp = new ArrayList<Project>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://dotnet-env.brdcijzrz7.eu-west-1.elasticbeanstalk.com/api/proj"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		Project p = new Project();
    	    
    		 p.setName(object.getJsonObject(i).get("Name").toString()); 
        	 p.setDescription(object.getJsonObject(i).get("Description").toString());
        	 p.setDateBegin( object.getJsonObject(i).get("DateBegin").toString());
        	 p.setDateEnd(object.getJsonObject(i).get("DateEnd").toString());
        	
        	 p.setTotalNbrRessources(Integer.parseInt(object.getJsonObject(i).get("TotalNbrRessources").toString()));
        	
        	 p.setEtat(object.getJsonObject(i).getInt("Etat"));
        	 lasp.add(p); 
    	
    	


    	
    	 
    	 System.out.println("ppppppppppppppppp : "+i);
    	}
    	
    	 System.out.println("SSSSS : "+lasp);
    	return lasp;
		
	}
	public static final String baseUri = "http://dotnet-env.brdcijzrz7.eu-west-1.elasticbeanstalk.com/api";
    private Client client = null;
    private WebTarget target = null;

    public ProjectService() {
        client = ClientBuilder.newClient();
        target = client.target(baseUri);
    }
    
    public void reloadUri() {
        target = null;
        target = client.target(baseUri);
    }
	@Override
	public void postRequest(Project p) {

		 reloadUri();
		 Project pack = new Project();
	        
	        pack.setName(p.Name);
	        pack.setDescription(p.Description);
	        pack.setDateBegin(p.DateBegin);
	        pack.setDateEnd(p.DateEnd);
	        pack.setTotalNbrRessources(p.TotalNbrRessources);
	        System.out.println("isssssssssssssssssssss"+p.TotalNbrRessources);
	        pack.setEtat(p.Etat);

	        target = target.path("/Project");
	// POST Request from Jersey Client
	        Response response = target.request(MediaType.APPLICATION_JSON)
	                .post(Entity.entity(pack, MediaType.APPLICATION_JSON), Response.class);
	        System.out.println(response);
	        if (response.getStatus() == 200) {
	            System.out.println("post success");

	        }
	        else System.out.println("fatal error");
	}

	/*@Override
	public void Consommationbyid(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://aminel-env.auzhnf3ycw.eu-west-1.elasticbeanstalk.com/api/WebProject?id="+id);
		WebTarget hello =target.path("");
		Response response =hello.request().get();
		
		String result=response.readEntity(String.class);
		System.out.println("XXXXXXXXXXX:"+result);

		response.close();
		
	}*/

	@Override
	public void DelRequest(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://dotnet-env.brdcijzrz7.eu-west-1.elasticbeanstalk.com/api/WebProject?id="+id);
		WebTarget hello =target.path("");
		Response response =hello.request().delete();
		
		 System.out.println("Project DELETED"+response.getStatus());	
		String result=response.readEntity(String.class);
		System.out.println("XXXXXXXXXXX:"+result);
		
		response.close();
		
	}
	@Override
	public void putRequest(int id, Project p) {
		Project pack = new Project();
        pack.setName(p.Name);
        pack.setDescription(p.Description);
        pack.setDateBegin(p.DateBegin);
        pack.setDateEnd(p.DateEnd);
        pack.setTotalNbrRessources(p.TotalNbrRessources);
        pack.setEtat(p.Etat);
       

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://dotnet-env.brdcijzrz7.eu-west-1.elasticbeanstalk.com/api/Upr?id="+id);
		Response response = target
		                 .request()
		                 .put(Entity.entity(pack, MediaType.APPLICATION_JSON));
		   System.out.println(response);
		
		
	}
	
	
	
	

}

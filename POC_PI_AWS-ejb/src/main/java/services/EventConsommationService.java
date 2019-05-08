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
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import DTO.Event;
 



/**
 * Session Bean implementation class DemandeurConsom
 * @param <Meeting>
 */
@Stateless
@LocalBean
public class EventConsommationService implements EventConsomationServiceRemote {


    public EventConsommationService() {
       
    }

    public List<Event> consommation1()
    {
    	List<Event>  lasp = new ArrayList<Event>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:2212/api/event"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		Event m = new Event();
     
    		
    	 	
       	 m.setEventId(Integer.parseInt(object.getJsonObject(i).get("EventId").toString())); 
    	 m.setSubject(object.getJsonObject(i).get("Subject").toString()); 
    	 m.setDescription(object.getJsonObject(i).get("Description").toString()); 
    	 m.setStart(object.getJsonObject(i).get("Start").toString()); 
    	 m.setEnd(object.getJsonObject(i).get("End").toString()); 
  


    	 lasp.add(m);
    	}
    	

return lasp;    	
    }

    
    
    
    @Override
   	public void Create(Event p) {
    	Client client = ClientBuilder.newClient();
  		WebTarget target = client.target("http://localhost:2212/api/eventP");
  		WebTarget hello =target.path("");
  		
  		Response response =hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON) );
  		
  		String result=response.readEntity(String.class);
  		System.out.println(result);
  		System.out.println("newwwwwwwwwwwwwwwwwwwwwwwwwwwww");


  		response.close();
  		
  		
  	}
    
     
   	@Override
   	public void Update(Event p , int id) {
   		Client client = ClientBuilder.newClient();
   		WebTarget target = client.target("http://localhost:2212/api/eventUp?id="+id);
   		WebTarget hello =target.path("");
   		
   		Response response =hello.request().put(Entity.entity(p, MediaType.APPLICATION_JSON) );
   		
   		String result=response.readEntity(String.class);
   		System.out.println(result);

   		response.close();
   		
   	}
   	
   	/*
   	@Override
	public void DelRequest(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:2212/api/event?id="+id);
		WebTarget hello =target.path("");
		Response response =hello.request(MediaType.APPLICATION_JSON_TYPE, MediaType.TEXT_PLAIN_TYPE).delete();
		
		 System.out.println("LOG DELETED"+response.getStatus());	
		String result=response.readEntity(String.class);
		System.out.println("XXXXXXXXXXX:"+result);
		
		response.close();
		
	}  	
   	
	@Override
	public void DelRequest(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:2212/api/event?id="+id);
		WebTarget hello =target.path("");
		Response response =hello.request(MediaType.APPLICATION_JSON_TYPE, MediaType.TEXT_PLAIN_TYPE).delete();
		
		 System.out.println("LOG DELETED"+response.getStatus());	
		String result=response.readEntity(String.class);
		System.out.println("XXXXXXXXXXX:"+result);
		
		response.close();
		
	}
    */
	@Override
	public void DelRequest(int id) {
	 
	  		System.out.println("iddddddddd"+id);

			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://localhost:2212/api/event/"+id);
			WebTarget hello =target.path("");
			Response response =hello.request(MediaType.APPLICATION_JSON_TYPE, MediaType.TEXT_PLAIN_TYPE).delete();
			
			 System.out.println("LOG DELETED"+response.getStatus());	
			String result=response.readEntity(String.class);
			System.out.println("XXXXXXXXXXX:"+result);
			
			response.close();
			
		}

	@Override
	public void putEvent(int id, Event ev) {
		// TODO Auto-generated method stub
		Event event = new Event();
     //   task.setStartDate(p.StartDate);
      //  task.setEndDate(p.EndDate);
		event.setSubject(ev.Subject);
  		System.out.println("iddddddddd"+id);
  		System.out.println("OK");

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:2212/api/eventUp?id="+id);
		Response response = target
		                 .request()
		                 .put(Entity.entity(event, MediaType.APPLICATION_JSON));
		   System.out.println(response);
	}
	

  	
	
	
}

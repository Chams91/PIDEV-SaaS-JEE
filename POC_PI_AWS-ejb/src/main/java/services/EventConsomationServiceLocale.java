package services;

import java.util.List;

import DTO.Event;

public interface EventConsomationServiceLocale {
	public List<Event>  consommation1();
   	public void Create(Event p);
   	public void Update(Event p , int id);
	public void DelRequest(int id);
	public void putEvent(int id, Event ev);

}

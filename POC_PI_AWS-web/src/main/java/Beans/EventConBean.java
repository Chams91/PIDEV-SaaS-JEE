package Beans;

import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import services.EventConsommationService;
import DTO.Event;

import java.io.Serializable;
import java.util.ArrayList;
 
import javax.faces.view.ViewScoped;
import javax.inject.Named;
 
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
 




@ManagedBean
@SessionScoped
public class EventConBean {

	 public int EventId ;
	 public String Subject ;
     public String Description ;
     public String Start ;
     public String End ;
     public Event packs;
	

	
	private List<Event> listOfEvent = new ArrayList<Event>();
	@EJB
	EventConsommationService E1;


	
		
	public int getEventId() {
		return EventId;
	}
	public void setEventId(int eventId) {
		EventId = eventId;
	}
	
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getStart() {
		return Start;
	}
	public void setStart(String start) {
		Start = start;
	}
	public String getEnd() {
		return End;
	}
	public void setEnd(String end) {
		End = end;
	}

	
	
	
	public List<Event> getListOfEvent() {
		return listOfEvent;
	}
	public void setListOfEvent(List<Event> listOfEvent) {
		this.listOfEvent = listOfEvent;
	}

	@PostConstruct
	public void init() {
		listOfEvent = E1.consommation1();
	}
	
	
	
	
	
	
	
	
	
	
	public List<Event> getAllEvents() {

		return listOfEvent;
	}
	
	
	public void doAddEvent() {


		E1.Create(new Event(Subject, Description, Start, End, "green"  ) );
	
		listOfEvent = E1.consommation1();

	}
	
	
	public void doAddDocument() {
E1.Create(new Event(Subject, Description));
		
	//	Documents = dcr.consomation();


	}
	public String DeleteEvent(Integer ev) {
		E1.DelRequest(ev);
		listOfEvent = E1.consommation1();
		
	
		return "/Event?faces-redirect=true"	;
	}
	
	public void doUpEvent() {

		E1.Update(new Event(Subject, Description, Start, End),EventId);
	
		listOfEvent = E1.consommation1();
	}
	
	public String sup(Integer packId) {
		E1.DelRequest(packId);
		return "/Event?faces-redirect=true"	;
	
	}
	 public void postProcessXLS(Object document) {
	        HSSFWorkbook wb = (HSSFWorkbook) document;
	        HSSFSheet sheet = wb.getSheetAt(0);
	        CellStyle style = wb.createCellStyle();
	        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
	 
	        for (Row row : sheet) {
	            for (Cell cell : row) {
	                cell.setCellValue(cell.getStringCellValue().toUpperCase());
	                cell.setCellStyle(style);
	            }
	        }
	    }
	 
	 
	 
	 
	 public void modifier(Event ev){	
			
			//navigateTo ="/pages/admin/listEmploye?faces-redirect=true";
			//loggedIn = true;

			this.setSubject(ev.getSubject());
			
			//this.setDescription(ev.getDescription());

			this.setEventId(ev.getEventId());
		
	}

	public void mettreAjourTask(){
		
		E1.putEvent(EventId,new Event(Subject));
		
	}
}

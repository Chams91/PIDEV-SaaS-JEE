package tn.esprit.coursJpa.presentation.mbeans;
import java.security.Security;

import java.util.ArrayList;


import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import tn.esprit.imputation.entity.Project;
import tn.esprit.imputation.service.impl.ProjectService;



@ManagedBean(name="projectBean")

@SessionScoped
public class ProjectBean {

	public int ProjectId;
    public String Name ;	       
    public String DateBegin ;
    public String DateEnd;
    public String Description ;
    public int Etat ;
    public int TotalNbrRessources ;
    Project packs;
    public static List<Project> packss;
	private List<Project> listOfTask = new ArrayList<Project>();
	public int packIdToBeUpdate;
	private List<Project> listOfProject;
    //Mail things:
    private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";
    private static final String emailMsgTxt = "Project added successfuly";
    private static final String emailSubjectTxt = "Project managment platform";
    private static final String emailFromAddress = "chames.benalaya@gmail.com";
    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private static final String[] sendTo = { "chaima.benhsouna@esprit.tn"};
    
	
	@EJB
	 ProjectService pack;
	
	public ProjectBean() {}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getProjectId() {
		return ProjectId;
	}

	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}

	public int getPackIdToBeUpdate() {
		return packIdToBeUpdate;
	}

	public void setPackIdToBeUpdate(int packIdToBeUpdate) {
		this.packIdToBeUpdate = packIdToBeUpdate;
	}

	public List<Project> getListOfProject() {
		return listOfProject;
	}

	public void setListOfProject(List<Project> listOfProject) {
		this.listOfProject = listOfProject;
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

	public Project getPacks() {
		return packs;
	}

	public void setPacks(Project packs) {
		this.packs = packs;
	}

	public static List<Project> getPackss() {
		return packss;
	}

	public static void setPackss(List<Project> packss) {
		ProjectBean.packss = packss;
	}

	public List<Project> getListOfTask() {
		return listOfTask;
	}

	

	public List<Project> getCategories() {
		return listOfProject;
	}

	public void setCategories(List<Project> projects) {
		listOfProject = projects;
	}
		
	public List<Project> getINF() {
		packss = pack.Consommation();
		return packss;
	}

	public List<Project> getPackss1() {
		return packss;
	}

	public void setPackss1(List<Project> packss) {
		this.packss = packss;
	}

	public void getPack() {
		packss = new ArrayList<>();
		packss = pack.Consommation();
	}

	public void setPack(ProjectService pack) {
		this.pack = pack;
	}
	public List<Project> getListOfTask1() {
		return listOfTask;
	}
	public void setListOfTask(List<Project> listOfTask) {
		this.listOfTask = listOfTask;
	}
	@PostConstruct
	public void init() {
		listOfTask = pack.Consommation();
	}
	Project lloo = new Project("ssds","11-05-2019","25-07-2019",4,"desc",1);
	
	public Project getLloo() {
		return lloo;
	}

	public void setLloo(Project lloo) {
		this.lloo = lloo;
	}

	public List<Project> geeeettttetAllTasks() {
		return listOfTask;
	}
	public String supprimerssss(Integer packId) {
		pack.DelRequest(packId);
		listOfTask = pack.Consommation();
		return "/Get?faces-redirect=true"	;
			
	}
	public String modifier(Project cat){	
	
			//navigateTo ="/pages/admin/listEmploye?faces-redirect=true";
			//loggedIn = true;

			
			this.setProjectId(cat.getProjectId());
			this.setName(cat.getName());
			this.setDateBegin(cat.getDateBegin());
			this.setDateEnd(cat.getDateEnd());
			this.setTotalNbrRessources(cat.getTotalNbrRessources());
			this.setDescription(cat.getDescription());
			this.setEtat(cat.getEtat());
			return "/Try?faces-redirect=true"	;
			
		
	}
	
	public String mettreAjourPro(){
		
		pack.putRequest(ProjectId,new Project(Name,DateBegin,DateEnd,TotalNbrRessources,Description,Etat));
		listOfTask = pack.Consommation();
		
		return "/Get?faces-redirect=true"	;
		
	}
	
	
	public String addProject() throws MessagingException{
		
		pack.postRequest(new Project(Name,DateBegin,DateEnd,TotalNbrRessources,Description,Etat));
	
		new ProjectBean().sendSSLMessage(sendTo, emailSubjectTxt,
               emailMsgTxt, emailFromAddress);
	
		listOfTask = pack.Consommation();
        return "/Get?faces-redirect=true"	;

		
		
		
	}
	 public void sendSSLMessage(String recipients[], String subject,
	            String message, String from) throws MessagingException {
	        boolean debug = true;

	        Properties props = new Properties();
	        props.put("mail.smtp.host", SMTP_HOST_NAME);
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.debug", "true");
	        props.put("mail.smtp.port", SMTP_PORT);
	        props.put("mail.smtp.socketFactory.port", SMTP_PORT);
	        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
	        props.put("mail.smtp.socketFactory.fallback", "false");
	        Session session = Session.getInstance(props,
	                new javax.mail.Authenticator() {

	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication("chames.benalaya@gmail.com", "xrlzgxvtbfoseitj");
	                    }
	                });

	        session.setDebug(debug);

	        Message msg = new MimeMessage(session);
	        InternetAddress addressFrom = new InternetAddress(from);
	        msg.setFrom(addressFrom);

	        InternetAddress[] addressTo = new InternetAddress[recipients.length];
	        for (int i = 0; i < recipients.length; i++) {
	            addressTo[i] = new InternetAddress(recipients[i]);
	        }
	        msg.setRecipients(Message.RecipientType.TO, addressTo);

	        // Setting the Subject and Content Type
	        msg.setSubject(subject);
	        msg.setContent(message, "text/plain");
	        Transport.send(msg);
	        
	        
	    }
	
	
}

	
	
	
	


	
	


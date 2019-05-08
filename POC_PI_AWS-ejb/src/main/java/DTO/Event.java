package DTO;

public class Event {


	  public int EventId ;

      public String Subject ;

      public String Description ;

      public String Start ;
      public String End ;
      public String Themecolor ;
      public Byte IsFullDay ;

      

		
		
		public Event() {
			super();
		}


	
		
		

		public int getEventId() {
			return EventId;
		}

	





		public Byte getIsFullDay() {
			return IsFullDay;
		}





		public void setIsFullDay(Byte isFullDay) {
			IsFullDay = isFullDay;
		}



		public Event(String subject) {
			super();
			Subject = subject;
		}






		public Event(String subject, String description, String start, String end, Byte isFullDay) {
			super();
			Subject = subject;
			Description = description;
			Start = start;
			End = end;
			IsFullDay = isFullDay;
		}



		public Event(String subject, String description) {
			super();
			Subject = subject;
			Description = description;
		}

		public Event(int eventId, String subject, String description, String start, String end, String themecolor) {
			super();
			EventId = eventId;
			Subject = subject;
			Description = description;
			Start = start;
			End = end;
			Themecolor = themecolor;
		}

	
		public Event(String subject, String description, String start, String end) {
			super();
			Subject = subject;
			Description = description;
			Start = start;
			End = end;
		}


		public Event(String subject, String description, String start, String end, String themecolor) {
			super();
			Subject = subject;
			Description = description;
			Start = start;
			End = end;
			Themecolor = themecolor;
		}











		





		public Event(String subject, String description, String start, String end, String themecolor, Byte isFullDay) {
			super();
			Subject = subject;
			Description = description;
			Start = start;
			End = end;
			Themecolor = themecolor;
			IsFullDay = isFullDay;
		}






		public Event(int eventId, String subject, String description, String start, String end, String themecolor,
				Byte isFullDay) {
			super();
			EventId = eventId;
			Subject = subject;
			Description = description;
			Start = start;
			End = end;
			Themecolor = themecolor;
			IsFullDay = isFullDay;
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















		public Event(Byte isFullDay) {
			super();
			IsFullDay = isFullDay;
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






		public String getThemecolor() {
			return Themecolor;
		}






		public void setThemecolor(String themecolor) {
			Themecolor = themecolor;
		}






		public void setEventId(int eventId) {
			EventId = eventId;
		}






		@Override
		public String toString() {
			return "Event [EventId=" + EventId + ", Subject=" + Subject + ", Description=" + Description + ", Start="
					+ Start + ", End=" + End + ", Themecolor=" + Themecolor + ", IsFullDay=" + IsFullDay + "]";
		}










	

}

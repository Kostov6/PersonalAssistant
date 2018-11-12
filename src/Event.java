

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Event implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private Date eventDate;
	
	Event(String name,int year,int month,int date,int hourOfDay,int minute)
	{
		this.name=name;
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, date, hourOfDay, minute,0);
		eventDate = calendar.getTime();
	}

	public Event() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEventDate() {
		SimpleDateFormat format = new SimpleDateFormat(" HH:mm | yyyy-MM-dd ");
		return format.format(eventDate);
	}

	
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	@Override
	public String toString() {
		return name + " [" + eventDate + "]";
	}
	
}

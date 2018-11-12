import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/events")
public class EventsEndpoint {

	private class EventITest implements EventI,Serializable
	{
		private static final String filePath="";
		private static final long serialVersionUID = 1L;
		private List<Event> events;
		
		public EventITest()
		{
			events=new ArrayList<Event>();
			events.add(new Event("event 1",2018,11,12,15,30));
			events.add(new Event("event 2",2018,11,12,17,30));
			readFromFile();
		}
		
		
		@Override
		public void addEvent(String name, String date, String priority) {
			Event e=new Event();
			e.setName(name);
			SimpleDateFormat format = new SimpleDateFormat("HH:mm yyyy-MM-dd");
			try {
				e.setEventDate(format.parse(date));
				events.add(e);
				writeToFile();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

		@Override
		public Object[] getUpTo(Date date) {
			return events.toArray();
		}

		private void readFromFile()
		{
			
		}
		
		private void writeToFile()
		{
			
		}
		
	}
	
	@PUT
	@Path("/addEvent/{name}/{date}/{priority}")
	@Consumes("text/plain")
    public void addModel(@PathParam("name") String name,@PathParam("date") String date,@PathParam("priority") String priority)
    {
		EventI eventM=new EventITest();
		eventM.addEvent(name, date, priority);
    }
	
	@GET
	@Path("/get7DayInterval")
	@Produces("application/json")
	public Object[] get7DayInterval()
	{
		EventI eventM=new EventITest();
		return eventM.getUpTo(null);
	}

}

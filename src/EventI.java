import java.util.Date;

import javax.ws.rs.PathParam;

public interface EventI {

	void addEvent(String name,String date,String priority);
	
	Object[] getUpTo(Date date);
    
}

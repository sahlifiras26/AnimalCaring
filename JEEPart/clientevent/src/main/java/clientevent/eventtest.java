package clientevent;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entites.Event;
import iservices.IEventServiceRemote;
public class eventtest {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			
			IEventServiceRemote proxy = 
					(IEventServiceRemote) context.lookup("/piac-ear/piac-ejb/EventService!iservices.IEventServiceRemote"); 
						
			
			Event e = new Event();
			e.setName("test");
			proxy.AddEvent(e);
			
			
			
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

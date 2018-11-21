package iservices;

import java.util.List;

import javax.ejb.Local;

import entites.Event;
import entites.EventParticipation;
import entites.User;
@Local
public interface IParticipationservice {
	public  List<EventParticipation> getParticipation() ;
	public void AddParticipation (EventParticipation ep) ;
	public void EditParticipation (EventParticipation ep) ;

	public EventParticipation ShowParticipation(int id);
	public void DeletParticipation(EventParticipation ep);
public boolean checkparticipation(User user , Event event);
}

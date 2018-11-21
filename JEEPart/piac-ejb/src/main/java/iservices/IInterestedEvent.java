package iservices;

import javax.ejb.Local;

import entites.EventInterrested;
import entites.EventInterrestedId;
import entites.EventParticipation;



@Local
public interface IInterestedEvent {
	public void AddInterested (EventInterrested ep) ;
	public void DeletInterested(EventInterrested ep);
	public EventInterrested ShowInterest(int iduser , int idevent);

}

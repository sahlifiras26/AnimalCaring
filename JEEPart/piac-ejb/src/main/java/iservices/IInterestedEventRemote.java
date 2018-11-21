package iservices;

import javax.ejb.Remote;

import entites.EventInterrested;
@Remote
public interface IInterestedEventRemote {
	public void AddInterested (EventInterrested ep) ;
	public void DeletInterested(EventInterrested ep);
	public EventInterrested ShowInterest(int iduser , int idevent);

}

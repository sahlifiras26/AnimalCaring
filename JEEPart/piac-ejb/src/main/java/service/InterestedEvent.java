package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.IdClass;
import javax.persistence.PersistenceContext;

import entites.EventInterrested;
import entites.EventInterrestedId;
import entites.EventParticipation;
import iservices.IInterestedEvent;
import iservices.IInterestedEventRemote;

@LocalBean
@Stateless
public class InterestedEvent implements IInterestedEvent , IInterestedEventRemote {
	@PersistenceContext(name = "piac-ejb")
	private EntityManager em;

	@Override
	public void AddInterested(EventInterrested ep) {
		em.persist(ep);
	}

	@Override
	public void DeletInterested(EventInterrested ep) {
		em.remove(em.merge(ep));
	}

	@Override
	public EventInterrested ShowInterest(int iduser, int idevent) {
		// TODO Auto-generated method stub
		return (EventInterrested) em
				.createQuery("select e from EventInterrested e where e.id.iduser =:u and e.id.idevent = :p")
				.setParameter("u", iduser).setParameter("p", idevent).getSingleResult();

	}

}

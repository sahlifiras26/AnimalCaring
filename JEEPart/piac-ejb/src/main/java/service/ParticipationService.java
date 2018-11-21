package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entites.Event;
import entites.EventParticipation;
import entites.User;
import iservices.IParticipationservice;
import iservices.IParticipationserviceRemote;

@LocalBean
@Stateless
public class ParticipationService implements IParticipationservice  , IParticipationserviceRemote{
	@PersistenceContext(name = "piac-ejb")
	private EntityManager em;

	@Override
	public List<EventParticipation> getParticipation() {
		return em.createQuery("select e from EventParticipation e ").getResultList();
	}

	@Override
	public void AddParticipation(EventParticipation ep) {
		em.persist(ep);

	}

	@Override
	public EventParticipation ShowParticipation(int id) {
		return em.find(EventParticipation.class, id);
	}

	@Override
	public void DeletParticipation(EventParticipation ep) {
		em.remove(em.merge(ep));
	}

	@Override
	public boolean checkparticipation(User user, Event event) {

		if (em.createQuery("select e from EventParticipation e where e.user=:u and e.event=:p ")
				.setParameter("p", event).setParameter("u", user).getResultList().size() == 0)
			return true;

		else
			return false;
	}

	@Override
	public void EditParticipation(EventParticipation ep) {
		em.merge(ep);
	}

}

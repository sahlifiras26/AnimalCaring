package service;

import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entites.Event;
import iservices.IEventService;
import iservices.IEventServiceRemote;

@LocalBean
@Stateless
public class EventService implements IEventService , IEventServiceRemote {
	@PersistenceContext(name = "piac-ejb")
	private EntityManager em;

	@Override
	public List<Event> getEvents() {
		return em.createQuery("select e from Event e").getResultList();
	}

	@Override
	public void AddEvent(Event ev) {
		em.persist(ev);
	}

	@Override
	public void EditEvent(Event ev) {
		em.merge(ev);

	}

	@Override
	public Event ShowEvent(int id) {
		return em.find(Event.class, id);
	}

	@Override
	public void DeletEvent(Event ev) {
		em.remove(em.merge(ev));
	}

	@Override
	public List<Event> FindEventByName(String name) {
		return em.createQuery("select e from Event e where e.name like :a").setParameter("a", "%" + name + "%")
				.getResultList();
	}

	@Override
	public List<Event> FindEventByDate(Date date) {
		return em.createQuery("SELECT e FROM Event e WHERE e.dateBegin = :startDate ").setParameter("startDate", date)
				.getResultList();
	}

	@Override
	public List<Event> FindEventByDate2(Date datestart, Date dateend) {
		return em.createQuery("SELECT e FROM Event e WHERE e.dateBegin  BETWEEN :startDate AND :endDate ")
				.setParameter("startDate", datestart).setParameter("endDate", dateend).getResultList();
	}

}

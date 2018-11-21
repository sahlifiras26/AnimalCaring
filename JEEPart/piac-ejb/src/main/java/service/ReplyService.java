package service;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entites.Respond;
import iservices.ReplyServiceLocal;

/**
 * Session Bean implementation class ReplyService
 */
@Stateless
@LocalBean
public class ReplyService implements ReplyServiceLocal {

	  @PersistenceContext(name="piac-ejb")
		private EntityManager em;
    /**
     * Default constructor. 
     */
    public ReplyService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addRespond(Respond respond) {
		Date sysdate=new Date();
		respond.setCreatedAt(sysdate);
		em.persist(respond);
		
	}

	@Override
	public void updateRespond(Respond respond) {
		em.merge(respond);
		
	}

	@Override
	public void deleteRespond(Respond respond) {
	    em.remove(em.merge(respond));
		
	}

	@Override
	public Respond getRespond(int id) {
		return em.find(Respond.class, id);
	}

	@Override
	public List<Respond> getAllResponds() {
		return em.createQuery("SELECT r FROM Respond r").getResultList();
	}

	@Override
	public List<Respond> getRespondbyDiscussionId(int id) {
		return em.createQuery("Select r from Respond r where r.idDiscussion=:p").setParameter("p", id).getResultList();
	}

}

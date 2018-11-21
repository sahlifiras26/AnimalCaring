package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entites.Discussion;
import iservices.DiscussionServiceLocal;

/**
 * Session Bean implementation class DiscussionService
 */
@Stateless
@LocalBean
public class DiscussionService implements DiscussionServiceLocal {

	 @PersistenceContext(name="piac-ejb")
		private EntityManager em;
    /**
     * Default constructor. 
     */
    public DiscussionService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addDiscussion(Discussion discussion) {
		em.persist(discussion);
	}

	@Override
	public void updateDiscussion(Discussion discussion) {
		em.merge(discussion);	
	}

	@Override
	public void deleteDiscussion(Discussion discussion) {
		em.remove(em.merge(discussion));
		
	}

	@Override
	public Discussion getDiscussion(int id) {
		
		return em.find(Discussion.class, id);
	}

	@Override
	public List<Discussion> getAllDiscussions() {
		return em.createQuery("SELECT d FROM Discussion d").getResultList();
	}

	@Override
	public List<Discussion> getDiscussionbyForumId(int id) {
		return em.createQuery("Select d from Discussion d where d.idForum=:p").setParameter("p", id).getResultList();
	}

}

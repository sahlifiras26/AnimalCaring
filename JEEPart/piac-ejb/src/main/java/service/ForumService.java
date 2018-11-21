package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entites.Forum;
import iservices.ForumServiceLocal;

/**
 * Session Bean implementation class ForumService
 */
@Stateless
@LocalBean
public class ForumService implements ForumServiceLocal {

	@PersistenceContext(name="piac-ejb")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ForumService() {
        // TODO Auto-generated constructor stub
    }
    
   
	@Override
	public void addForum(Forum forum) {
		em.persist(forum);
		
	}
	@Override
	public void updateForum(Forum forum) {
	em.merge(forum);
	}
	@Override
	public void deleteForum(Forum forum) {
		em.remove(em.merge(forum));
		
	}
	@Override
	public Forum getForum(int id) {
		return em.find(Forum.class, id);
	}
	@Override
	public List<Forum> getAllForums() {
		return em.createQuery("SELECT f FROM Forum f").getResultList();
	}
	@Override
	public List<Forum> getForumbyid(int id) {
		
		return em.createQuery("Select f from Forum f where f.idForum=:p").setParameter("p", id).getResultList();

	}

}

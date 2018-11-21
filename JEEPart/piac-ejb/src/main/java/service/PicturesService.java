package service;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entites.AnnouncementCategories;
import entites.pictures;
import iservices.IPicturesService;

@LocalBean
@Stateless
public class PicturesService implements IPicturesService {
	@PersistenceContext(name="piac-ejb")
	private EntityManager em ;

	@Override
	public Collection<pictures> getAnnouncementPictures() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT e FROM pictures e where announcement_idAnnouncement =1");
		return (Collection<pictures>) query.getResultList();
	}

	@Override
	public Collection<pictures> getPictures() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT e FROM AnnouncementCategories e");
		return (Collection<pictures>) query.getResultList();
	}

	@Override
	public void AddPicture(pictures ac) {
		// TODO Auto-generated method stub
		em.persist(ac);
	}

	@Override
	public void EditPictures(pictures ac) {
		// TODO Auto-generated method stub
		em.merge(ac);
	}

	@Override
	public pictures ShowPicture(int id) {
		// TODO Auto-generated method stub
		return em.find(pictures.class, id);
	}

	@Override
	public void DeletePictures(pictures ac) {
		// TODO Auto-generated method stub
		em.remove(em.merge(ac));
	}
}

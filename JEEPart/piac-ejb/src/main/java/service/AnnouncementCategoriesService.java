package service;

import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entites.AnnouncementCategories;

import iservices.IAnnouncementCategoriesService;

@LocalBean
@Stateless
public class AnnouncementCategoriesService implements IAnnouncementCategoriesService {
@PersistenceContext(name="piac-ejb")
private EntityManager em ;
@Override
public Collection<AnnouncementCategories> getAnnouncementCategories() {
// TODO Auto-generated method stub
//return em.createQuery("select ac from AnnouncementCategories ac" ).getResultList();
Query query = em.createQuery("SELECT e FROM AnnouncementCategories e");
return (Collection<AnnouncementCategories>) query.getResultList();
}

@Override
public void AddAnnouncementCategory(AnnouncementCategories ac) {
// TODO Auto-generated method stub
em.persist(ac);
}

@Override
public void EditAnnouncementCategory(AnnouncementCategories ac) {
// TODO Auto-generated method stub
em.merge(ac);
}

@Override
public AnnouncementCategories ShowAnnouncementCategory(int id) {
// TODO Auto-generated method stub
return em.find(AnnouncementCategories.class, id);
}

@Override
public void DeleteAnnouncementCategory(AnnouncementCategories ac) {
// TODO Auto-generated method stub
em.remove(em.merge(ac));
}

@Override
public Collection<AnnouncementCategories> getAnnouncementsCategories() {
	// TODO Auto-generated method stub
	Query query = em.createQuery("SELECT e FROM Announcement e where category_idCategory =2");
	return (Collection<AnnouncementCategories>) query.getResultList();
}

}

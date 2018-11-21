package iservices;

import java.util.Collection;

import javax.ejb.Local;

import entites.AnnouncementCategories;
@Local
public interface IAnnouncementCategoriesService {
public  Collection<AnnouncementCategories> getAnnouncementCategories() ;
public  Collection<AnnouncementCategories> getAnnouncementsCategories() ;
public void AddAnnouncementCategory (AnnouncementCategories ac) ;
public void EditAnnouncementCategory(AnnouncementCategories ac);
public AnnouncementCategories ShowAnnouncementCategory(int id);
public void DeleteAnnouncementCategory(AnnouncementCategories ac);
}

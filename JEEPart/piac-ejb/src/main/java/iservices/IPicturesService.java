package iservices;

import java.util.Collection;

import javax.ejb.Local;

import entites.AnnouncementCategories;
import entites.pictures;
@Local
public interface IPicturesService {
	public  Collection<pictures> getPictures() ;
	public void AddPicture (pictures ac) ;
	public void EditPictures(pictures ac);
	public pictures ShowPicture(int id);
	public void DeletePictures(pictures ac);
	Collection<pictures> getAnnouncementPictures();
}

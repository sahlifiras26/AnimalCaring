package entites;

import entites.Announcement;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: pictures
 *
 */
@Entity

public class pictures implements Serializable {

	   
	@Id
	private Integer idPictures;
	private String path;
	private Integer priority;
	@ManyToOne
	private Announcement announcement;
	private static final long serialVersionUID = 1L;

	public pictures() {
		super();
	}   
	public Integer getIdPictures() {
		return this.idPictures;
	}

	public void setIdPictures(Integer idPictures) {
		this.idPictures = idPictures;
	}   
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}   
	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}   
	public Announcement getAnnouncement() {
		return this.announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}
   
}

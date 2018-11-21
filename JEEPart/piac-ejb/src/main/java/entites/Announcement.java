package entites;

import entites.AnnouncementCategories;
import entites.User;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Announcement
 *
 */
@Entity

public class Announcement implements Serializable {

	   
	@Id
	private Integer idAnnouncement;
	private String title;
	private String description;
	private float price;
	private boolean confirmed;
	private boolean deleted;
	private Timestamp timeCreated;
	private Timestamp timeModified;
	@ManyToOne
	private User user;
	@ManyToOne
	private AnnouncementCategories category;
	private static final long serialVersionUID = 1L;

	public Announcement() {
		super();
	}   
	public Integer getIdAnnouncement() {
		return this.idAnnouncement;
	}

	public void setIdAnnouncement(Integer idAnnouncement) {
		this.idAnnouncement = idAnnouncement;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}   
	public boolean getConfirmed() {
		return this.confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}   
	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}   
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}   
	public Timestamp getTimeModified() {
		return this.timeModified;
	}

	public void setTimeModified(Timestamp timeModified) {
		this.timeModified = timeModified;
	}   
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}   
	public AnnouncementCategories getCategory() {
		return this.category;
	}

	public void setCategory(AnnouncementCategories category) {
		this.category = category;
	}
   
}

package entites;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AnnouncementCategories
 *
 */
@Entity

public class AnnouncementCategories implements Serializable {

	   
	@Id
	private Integer idCategory;
	private String name;
	private String description;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User user;
	
	public AnnouncementCategories(Integer idCategory, String name) {
		super();
		this.idCategory = idCategory;
		this.name = name;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public AnnouncementCategories() {
		super();
	}   
	public Integer getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}

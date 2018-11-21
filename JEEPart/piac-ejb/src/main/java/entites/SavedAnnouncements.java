package entites;

import java.io.Serializable;
import java.lang.Integer;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SavedAnnouncements
 *
 */
@Entity

public class SavedAnnouncements implements Serializable {

	   
	@Id
	private Integer idSave;
	private Timestamp timeSaved;
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private static final long serialVersionUID = 1L;

	public SavedAnnouncements() {
		super();
	}   
	public Integer getIdSave() {
		return this.idSave;
	}

	public void setIdSave(Integer idSave) {
		this.idSave = idSave;
	}   
	public Timestamp getTimeSaved() {
		return this.timeSaved;
	}

	public void setTimeSaved(Timestamp timeSaved) {
		this.timeSaved = timeSaved;
	}
   
}

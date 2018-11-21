package entites;

import java.io.Serializable;
import java.lang.Integer;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EventInterrested
 *
 */
@Entity

public class EventInterrested implements Serializable {
	@EmbeddedId
	@GeneratedValue
	private EventInterrestedId id ;
	@ManyToOne
	@JoinColumn(name="idUser",referencedColumnName="idUser",updatable=false,insertable=false)
	private User user;
	@ManyToOne
	@JoinColumn(name="idEvent",referencedColumnName="idEvent",updatable=false,insertable=false)
	private Event event;
	
	private Date datecreated ;
	/**
	 * @return the id
	 */
	public EventInterrestedId getId() {
		return id;
	}
	/**
	 * @return the datecreated
	 */
	public Date getDatecreated() {
		return datecreated;
	}
	/**
	 * @param datecreated the datecreated to set
	 */
	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(EventInterrestedId id) {
		this.id = id;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}
	/**
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}
	public EventInterrested() {
		super();
	}
   
}

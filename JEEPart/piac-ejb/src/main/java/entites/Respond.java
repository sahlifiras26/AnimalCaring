package entites;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Respond
 *
 */
@Entity

public class Respond implements Serializable {

	   
	@Id
	private int idRespond;
	private String contentRespond;
	private boolean enabled;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedAt;
	private String image;
	private String video;
	@ManyToOne
	private User author;
	@ManyToOne
	private Discussion discussion;
	
	private static final long serialVersionUID = 1L;

	public Respond() {
		super();
	}   
	public int getIdRespond() {
		return this.idRespond;
	}

	public void setIdRespond(int idRespond) {
		this.idRespond = idRespond;
	}   
	public String getContentRespond() {
		return this.contentRespond;
	}

	public void setContentRespond(String contentRespond) {
		this.contentRespond = contentRespond;
	}   
	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}   
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}   
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}   
	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
	public User getAuthor() {
		return author;}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Discussion getDiscussion() {
		return discussion;
	}
	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}
	@Override
	public String toString() {
		return "Respond [idRespond=" + idRespond + ", contentRespond=" + contentRespond + ", enabled=" + enabled
				+ ", createdAt=" + createdAt + ", image=" + image + ", video=" + video + ", author=" + author
				+ ", discussion=" + discussion + "]";
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
   
}

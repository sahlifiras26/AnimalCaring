package entites;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Discussion
 *
 */
@Entity

public class Discussion implements Serializable {

	@Id
	private Integer idDiscussion;
	private String subjectDiscussion;
	private String contentDiscussion;
	private Integer nbResponds;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedAt;
	private boolean enabled;
	private String image;
	private String video;
	@ManyToOne
	private User author;
	@ManyToOne
	private Forum forum;
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	private static final long serialVersionUID = 1L;

	public Discussion() {
		super();
	}   
	public Integer getIdDiscussion() {
		return this.idDiscussion;
	}

	public void setIdDiscussion(Integer idDiscussion) {
		this.idDiscussion = idDiscussion;
	}   
	public String getSubjectDiscussion() {
		return this.subjectDiscussion;
	}

	public void setSubjectDiscussion(String subjectDiscussion) {
		this.subjectDiscussion = subjectDiscussion;
	}   
	public String getContentDiscussion() {
		return this.contentDiscussion;
	}

	public void setContentDiscussion(String contentDiscussion) {
		this.contentDiscussion = contentDiscussion;
	}   
	public Integer getNbResponds() {
		return this.nbResponds;
	}

	public void setNbResponds(Integer nbResponds) {
		this.nbResponds = nbResponds;
	}   
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}   
	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	@Override
	public String toString() {
		return "Discussion [idDiscussion=" + idDiscussion + ", subjectDiscussion=" + subjectDiscussion
				+ ", contentDiscussion=" + contentDiscussion + ", nbResponds=" + nbResponds + ", createdAt=" + createdAt
				+ ", enabled=" + enabled + ", image=" + image + ", video=" + video + ", author=" + author + ", forum="
				+ forum + "]";
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
   
}

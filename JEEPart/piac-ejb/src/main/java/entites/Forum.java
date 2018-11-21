package entites;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Forum
 *
 */
@Entity

public class Forum implements Serializable {
//commit test by omar reg
	   
	@Id
	private int idForum;
	private String nameForum;
	private String descForum;
	private int nbDiscussions;
	@ManyToOne
	private User supervisor;
	
	public User getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(User supervisor) {
		this.supervisor = supervisor;
	}
	private static final long serialVersionUID = 1L;

	public Forum() {
		super();
	}   
	public Integer getIdForum() {
		return this.idForum;
	}

	public void setIdForum(Integer idForum) {
		this.idForum = idForum;
	}   
	public String getNameForum() {
		return this.nameForum;
	}

	public void setNameForum(String nameForum) {
		this.nameForum = nameForum;
	}   
	public String getDescForum() {
		return this.descForum;
	}

	public void setDescForum(String descForum) {
		this.descForum = descForum;
	}   
	public Integer getNbDiscussions() {
		return this.nbDiscussions;
	}

	public void setNbDiscussions(Integer nbDiscussions) {
		this.nbDiscussions = nbDiscussions;
	}
	@Override
	public String toString() {
		return "Forum [idForum=" + idForum + ", nameForum=" + nameForum + ", descForum=" + descForum
				+ ", nbDiscussions=" + nbDiscussions + ", supervisor=" + supervisor + "]";
	}
	
   
}

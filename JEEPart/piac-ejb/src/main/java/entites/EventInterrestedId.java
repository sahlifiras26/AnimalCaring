package entites;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EventInterrestedId implements Serializable {

private int iduser ; 
private Integer idevent ;
/**
 * @return the iduser
 */
public int getIduser() {
	return iduser;
}
/**
 * @param iduser the iduser to set
 */
public void setIduser(int iduser) {
	this.iduser = iduser;
}
/**
 * @return the idevent
 */
public int getIdevent() {
	return idevent;
}
/**
 * @param idevent the idevent to set
 */
public void setIdevent(int idevent) {
	this.idevent = idevent;
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + idevent;
	result = prime * result + iduser;
	return result;
}
/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	EventInterrestedId other = (EventInterrestedId) obj;
	if (idevent != other.idevent)
		return false;
	if (iduser != other.iduser)
		return false;
	return true;
}

}

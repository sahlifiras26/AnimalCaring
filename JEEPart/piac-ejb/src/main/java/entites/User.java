package entites;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	private Integer idUser;
	private String firstName;
	private String lastName;
	private Date dateBirth;
	private Integer phoneNumber;
	private String email;
	private String pwd;
	private String gender;
	private String location;
	private Date dateCreated;
	private Date dateModified;
	private String img;
	private String roles;
	private boolean isDoctor;
	private String isDoctorStatus;
	private boolean isTrainer;
	private boolean isFostercarer;
	private boolean isRepresentative;
	private String localAdress;
	private String description;
	private Integer extraPhone;
	private String extraEmail;
	private String extraImg;
	
	
	
	

	
	public void setDoctor(boolean isDoctor) {
		this.isDoctor = isDoctor;
	}
	public void setTrainer(boolean isTrainer) {
		this.isTrainer = isTrainer;
	}
	public void setFostercarer(boolean isFostercarer) {
		this.isFostercarer = isFostercarer;
	}
	public void setRepresentative(boolean isRepresentative) {
		this.isRepresentative = isRepresentative;
	}
	

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public Date getDateBirth() {
		return this.dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}   
	public Integer getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}   
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}   
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}   
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}   
	public Date getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}   
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}   
	public String getRoles() {
		return this.roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}   
	public boolean getIsDoctor() {
		return this.isDoctor;
	}

	public void setIsDoctor(boolean isDoctor) {
		this.isDoctor = isDoctor;
	}   
	
	public String getIsDoctorStatus() {
		return isDoctorStatus;
	}
	public void setIsDoctorStatus(String isDoctorStatus) {
		this.isDoctorStatus = isDoctorStatus;
	}
	public boolean getIsTrainer() {
		return this.isTrainer;
	}

	public void setIsTrainer(boolean isTrainer) {
		this.isTrainer = isTrainer;
	}   
	public boolean getIsFostercarer() {
		return this.isFostercarer;
	}

	public void setIsFostercarer(boolean isFostercarer) {
		this.isFostercarer = isFostercarer;
	}   
	public boolean getIsRepresentative() {
		return this.isRepresentative;
	}

	public void setIsRepresentative(boolean isRepresentative) {
		this.isRepresentative = isRepresentative;
	}   
	public String getLocalAdress() {
		return this.localAdress;
	}

	public void setLocalAdress(String localAdress) {
		this.localAdress = localAdress;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Integer getExtraPhone() {
		return this.extraPhone;
	}

	public void setExtraPhone(Integer extraPhone) {
		this.extraPhone = extraPhone;
	}   
	public String getExtraEmail() {
		return this.extraEmail;
	}

	public void setExtraEmail(String extraEmail) {
		this.extraEmail = extraEmail;
	}   
	public String getExtraImg() {
		return this.extraImg;
	}

	public void setExtraImg(String extraImg) {
		this.extraImg = extraImg;
	}
   
}

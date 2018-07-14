package br.ufjf.testerds.domains;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "`user`")
public abstract class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	@JsonIgnore
	private String password;
	private String avatarUrl;
	private String preferredLang;
	private boolean connected;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date creationDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date birthDay;
	
	@OneToMany(mappedBy = "id.user")
    private Set<CurrentStages> currentStages = new HashSet<>();
	
	@OneToMany(mappedBy = "id.user")
	private Set<CurrentProgress> currentProgresses = new HashSet<>();

	public User() {
		
	}
	
	public User(Integer id, String fistname, String lastname, String email, String password, String avatarUrl, Date birthDay, String preferredLang) {
		super();
		this.id = id;
		this.firstname = fistname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.avatarUrl = avatarUrl;
		this.birthDay = birthDay;	
		this.preferredLang = preferredLang;
		this.creationDate = new Date();
		this.connected = false;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}	
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthDay() {
		return birthDay;
	}
	
	
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}


	public Set<CurrentStages> getCurrentStages() {
		return currentStages;
	}


	public void setCurrentStages(Set<CurrentStages> currentStages) {
		this.currentStages = currentStages;
	}
	
	public Set<CurrentProgress> getCurrentProgresses() {
		return currentProgresses;
	}


	public void setCurrentProgresses(Set<CurrentProgress> currentProgresses) {
		this.currentProgresses = currentProgresses;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getPreferredLang() {
		return preferredLang;
	}

	public void setPreferredLang(String preferredLang) {
		this.preferredLang = preferredLang;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

package br.ufjf.testerds.domains;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CurrentProgress implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private CurrentProgressPK id = new CurrentProgressPK();
	private Boolean done;
	
	public CurrentProgress() {}
	
	public CurrentProgress(User user, Boolean done) {
		id.setUser(user);
		this.done = done;
	}
	
	public CurrentProgress(User user, SubLevel subLevel, Boolean done) {
		id.setUser(user);
		id.setSubLevel(subLevel);
		this.done = done;
	}
	
	public Integer getSubLevel() {
		return this.id.getSubLevel().getId();
	}
	
	public void setSubLevel(SubLevel subLevel) {
		this.id.setSubLevel(subLevel);
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}
	
	@JsonIgnore
	public User getUser() {
		return id.getUser();
	}
	
	public void setUser(User user) {
		this.id.setUser(user);
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
		CurrentProgress other = (CurrentProgress) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

package br.ufjf.testerds.domains;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CurrentStages implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CurrentStagesPK id = new CurrentStagesPK();
	
	private Integer sublevel_id;
	
	private Boolean complete;
	
	public CurrentStages() {}
	
	public CurrentStages(User user, Level level, Integer sublevel_id) {
		id.setUser(user);
		id.setLevel(level);
		this.sublevel_id = sublevel_id;
		this.setComplete(false);
	}

	@JsonIgnore
	public CurrentStagesPK getId() {
		return id;
	}

	public void setId(CurrentStagesPK id) {
		this.id = id;
	}
	
	@JsonIgnore
	public User getUser() {
		return id.getUser();
	}
	
	public void setUser(User user) {
		id.setUser(user);
	}
	
	public Integer getLevel() {
		return id.getLevel();
	}
	
	public void setLevel(Level level) {
		id.setLevel(level);
	}
	
	public Integer getCurrentSubLevel() {
		return this.sublevel_id;
	}
	
	public void setCurrentSubLevel(Integer currentSubLevelId) {
		this.sublevel_id = currentSubLevelId;	
	}

	public Boolean getComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
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
		CurrentStages other = (CurrentStages) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

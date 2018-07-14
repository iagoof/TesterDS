package br.ufjf.testerds.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SubLevel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private Integer position;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="level_id")
	private Level level;
	
	@OneToMany(mappedBy="subLevel")
	private List<CodeClass> baseCode = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="subLevel")
	private List<CodeClass> testCode = new ArrayList<>();
 	
	public SubLevel() {
		this.description = "";
	}
	
	public SubLevel(Integer id, String description, Level level, Integer position) {
		super();
		this.id = id;
		this.description = description;
		this.level = level;
		this.position = position;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer newPosition) {
		this.position = newPosition;
	}

	public List<CodeClass> getBaseCode() {
		return baseCode;
	}

	public void setBaseCode(List<CodeClass> baseCode) {
		this.baseCode = baseCode;
	}

	public List<CodeClass> getTestCode() {
		return testCode;
	}

	public void setTestCode(List<CodeClass> testCode) {
		this.testCode = testCode;
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
		SubLevel other = (SubLevel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

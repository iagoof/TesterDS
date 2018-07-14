package br.ufjf.testerds.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CodeClass implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    private String className;
    private String code;
    private String type;	// Two options: 1) 'code' = example class - 2) 'test' = test class
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="sub_level_id")
    private SubLevel subLevel;

    public CodeClass() {}
    
    public CodeClass(Integer id, String className, String code, String type, SubLevel subLevel) {
    	super();
    	this.id = id;
        this.className = className;
        this.code = code;
        this.type = type;
        this.subLevel = subLevel;
    }

    
    public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public SubLevel getSubLevel() {
		return subLevel;
	}

	public void setSubLevel(SubLevel subLevel) {
		this.subLevel = subLevel;
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
		CodeClass other = (CodeClass) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

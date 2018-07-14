package br.ufjf.testerds.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufjf.testerds.domains.SubLevel;

public class LevelDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String description;
	private List<SubLevel> subLevels = new ArrayList<>();
	
	public LevelDTO() {}
	
	public LevelDTO(Integer id, String description, List<SubLevel> list) {
		super();
		this.id = id;
		this.description = description;
		this.subLevels = list;
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

	public List<SubLevel> getSubLevels() {
		return subLevels;
	}

	public void setSubLevels(List<SubLevel> subLevels) {
		this.subLevels = subLevels;
	}
		
}

package br.ufjf.testerds.dtos;

import java.io.Serializable;

public class SubLevel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String description;
	private Integer levelId;
	private String baseCode;
	
	public SubLevel() {}

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

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getBaseCode() {
		return baseCode;
	}

	public void setBaseCode(String baseCode) {
		this.baseCode = baseCode;
	}
}

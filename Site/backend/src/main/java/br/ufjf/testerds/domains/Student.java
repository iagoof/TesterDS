package br.ufjf.testerds.domains;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Student extends User{

	private static final long serialVersionUID = 1L;
	
	public Student() {}
	
	public Student(Integer id, String fistName, String lastName, String email, String password, String avatarUrl, Date birthDay, String preferredLang) {
		super(id, fistName, lastName, email, password, avatarUrl, birthDay, preferredLang);
	}

}

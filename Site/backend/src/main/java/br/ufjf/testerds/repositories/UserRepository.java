package br.ufjf.testerds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufjf.testerds.domains.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findOne(Integer id);

	User findByEmail(String email);

}

package br.ufjf.testerds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufjf.testerds.domains.CodeClass;

@Repository
public interface CodeClassRepository extends JpaRepository<CodeClass, Integer>{

}

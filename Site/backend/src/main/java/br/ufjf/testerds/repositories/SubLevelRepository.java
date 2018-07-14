package br.ufjf.testerds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufjf.testerds.domains.SubLevel;

@Repository
public interface SubLevelRepository extends JpaRepository<SubLevel, Integer>{	
}

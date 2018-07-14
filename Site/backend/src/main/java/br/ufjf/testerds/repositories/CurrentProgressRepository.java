package br.ufjf.testerds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufjf.testerds.domains.CurrentProgress;

@Repository
public interface CurrentProgressRepository extends JpaRepository<CurrentProgress, Integer>{

}

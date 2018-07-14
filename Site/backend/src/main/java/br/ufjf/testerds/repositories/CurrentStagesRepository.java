package br.ufjf.testerds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufjf.testerds.domains.CurrentStages;

@Repository
public interface CurrentStagesRepository extends JpaRepository<CurrentStages, Integer>{

}

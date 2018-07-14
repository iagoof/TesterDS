package br.ufjf.testerds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ufjf.testerds.domains.Level;
import br.ufjf.testerds.domains.SubLevel;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer>{

	@Query("select sl from SubLevel sl, CurrentStages cs where sl.id = cs.sublevel_id and cs.id.user.id = ?1 and cs.id.level.id = ?2")
	SubLevel findCurrentSublevelsByUser(Integer userId, Integer levelId);
}

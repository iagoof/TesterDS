package br.ufjf.testerds.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufjf.testerds.services.LevelService;

@RestController
@RequestMapping(value="/levels")
public class LevelResource {
	
	@Autowired private LevelService levelService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(levelService.findAll());
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		return ResponseEntity.ok().body(levelService.findLevelById(id));
	}
	
	@RequestMapping(value="/nav", method=RequestMethod.GET)
	public ResponseEntity<?> find() {
		return ResponseEntity.ok().body(levelService.getLevelsNav());
	}
	
	@RequestMapping(value="/{userId}/currents", method=RequestMethod.GET)
	public ResponseEntity<?> findLevelsWithCurrentStages(@PathVariable Integer userId) {
		return ResponseEntity.ok().body(levelService.getLevelsWithCurrentSubLevels(userId));
	}
}

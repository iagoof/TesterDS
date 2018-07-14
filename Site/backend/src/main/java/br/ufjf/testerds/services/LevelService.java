package br.ufjf.testerds.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufjf.testerds.domains.Badge;
import br.ufjf.testerds.domains.Level;
import br.ufjf.testerds.domains.LevelNav;
import br.ufjf.testerds.domains.SubLevel;
import br.ufjf.testerds.repositories.LevelRepository;
import br.ufjf.testerds.utils.exceptions.ObjectNotFoundException;
import br.ufjf.testerds.utils.messages.ErrorsMessages;

@Service
public class LevelService {

	@Autowired private LevelRepository repository;
	
	public List<Level> findAll() {
		List<Level> obj = repository.findAll();
		
		if(obj == null) {
			throw new ObjectNotFoundException(ErrorsMessages.getObjectNotFoundMessage(Level.class.getName()));
		}
		
		return obj;
	}
	
	public Level findLevelById(Integer id) {
		Level obj = repository.findOne(id);
		
		if(obj == null) {
			throw new ObjectNotFoundException(ErrorsMessages.getObjectNotFoundMessage(id, Level.class.getName()));
		}
		
		return obj;
	}
	
	public List<LevelNav> getLevelsNav() {
		List<Level> levels = this.findAll();
		List<LevelNav> levelsNav = new ArrayList<>();
	
		for (Level level : levels) {
			LevelNav levelNav = new LevelNav();
		    levelNav.setTitle("Level " + level.getPosition());
		    levelNav.setLink("/levels/" + level.getId());
		    levelNav.setBadge(new Badge("info", "COMPLETE"));
		    levelsNav.add(levelNav);
		}
		
		return levelsNav;
	}
	
	
	public List<Level> getLevelsWithCurrentSubLevels(Integer userId) {
		List<Level> levels = this.findAll();
		
		if(levels == null) {
			throw new ObjectNotFoundException(ErrorsMessages.getObjectNotFoundMessage(Level.class.getName()));
		}
		
		for (Level level : levels) {
			level.getSubLevels().clear();
			SubLevel current = this.repository.findCurrentSublevelsByUser(userId, level.getId());
			level.getSubLevels().add(current);
		}
		
		return levels;
	}
	
}

package br.ufjf.testerds.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufjf.testerds.domains.SubLevel;
import br.ufjf.testerds.repositories.SubLevelRepository;
import br.ufjf.testerds.utils.exceptions.ObjectNotFoundException;
import br.ufjf.testerds.utils.messages.ErrorsMessages;


@Service
public class SubLevelService {
	
	@Autowired private SubLevelRepository repository;
	
	public List<SubLevel> findAll() {
		List<SubLevel> obj = repository.findAll();
		
		if(obj == null) {
			throw new ObjectNotFoundException(ErrorsMessages.getObjectNotFoundMessage(SubLevel.class.getName()));
		}
		
		return obj;
	}
	
	public SubLevel findSubLevelById(Integer id) {
		SubLevel obj = repository.findOne(id);
		
		if(obj == null) {
			throw new ObjectNotFoundException(ErrorsMessages.getObjectNotFoundMessage(id, SubLevel.class.getName()));
		}
		
		return obj;
	}

}

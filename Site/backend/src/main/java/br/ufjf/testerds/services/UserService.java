package br.ufjf.testerds.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufjf.testerds.domains.CurrentProgress;
import br.ufjf.testerds.domains.SubLevel;
import br.ufjf.testerds.domains.User;
import br.ufjf.testerds.repositories.CurrentProgressRepository;
import br.ufjf.testerds.repositories.SubLevelRepository;
import br.ufjf.testerds.repositories.UserRepository;
import br.ufjf.testerds.utils.exceptions.ObjectNotFoundException;
import br.ufjf.testerds.utils.messages.ErrorsMessages;

@Service
public class UserService {

	@Autowired private UserRepository userRepository;
	@Autowired private SubLevelRepository subLevelRepository;
	@Autowired private CurrentProgressRepository currentProgressRepository;
	
	public List<User> findAll() {
		List<User> obj = userRepository.findAll();
		
		if(obj == null) {
			throw new ObjectNotFoundException(ErrorsMessages.getObjectNotFoundMessage(User.class.getName()));
		}
		
		return obj;
	}
	
	public User findUserById(Integer id) {
		User obj = userRepository.findOne(id);
		
		if(obj == null) {
			throw new ObjectNotFoundException(ErrorsMessages.getObjectNotFoundMessage(id, User.class.getName()));
		}
		
		return obj;
	}
	
	public User findUserByEmail(String email) {
		User obj = userRepository.findByEmail(email);
		
		if(obj == null) {
			throw new ObjectNotFoundException(ErrorsMessages.getObjectNotFoundMessage(email, User.class.getName()));
		}
		
		return obj;
	}
	
	public void save(User user) {
		
		userRepository.save(Arrays.asList(user));
		
		// Ensure that all sublevels will be initialized
		try{
			List<SubLevel> subLevels = subLevelRepository.findAll();
			List<CurrentProgress> currentsProgress = new ArrayList<>(); 
			
			for (SubLevel subLevel : subLevels) {
				CurrentProgress currentProgress = new CurrentProgress(user, subLevel, false);
				currentsProgress.add(currentProgress);
			}
			
			currentProgressRepository.save(currentsProgress);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public void save(List<User> users) {
		
		for (User user : users) {			
			userRepository.save(Arrays.asList(user));
			
			// Ensure that all sublevels will be initialized
			try{
				List<SubLevel> subLevels = subLevelRepository.findAll();
				List<CurrentProgress> currentsProgress = new ArrayList<>(); 
				
				for (SubLevel subLevel : subLevels) {
					CurrentProgress currentProgress = new CurrentProgress(user, subLevel, false);
					currentsProgress.add(currentProgress);
				}
				
				currentProgressRepository.save(currentsProgress);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

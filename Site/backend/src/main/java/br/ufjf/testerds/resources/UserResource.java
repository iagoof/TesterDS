package br.ufjf.testerds.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufjf.testerds.domains.User;
import br.ufjf.testerds.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		return ResponseEntity.ok().body(service.findUserById(id));
	}
	
	// Improve this auth method
	@RequestMapping(value="/login/{email}/{password}/", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String email, @PathVariable String password) {
		User user = service.findUserByEmail(email);
		System.out.println("User: " + user);
		if(user != null) {
			if(user.getPassword().equals(password)) {
				return ResponseEntity.ok().body(user);					
			}
			else {
				return ResponseEntity.status(401).body("Error: Password is wrong!");
			}
		} else {
			return ResponseEntity.status(401).body("Error: This email is not registered!");
		}
	}
}

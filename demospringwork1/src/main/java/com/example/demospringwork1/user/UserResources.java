package com.example.demospringwork1.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResources {
	
	@Autowired
	private UserDaoServices service;

	
	@GetMapping("/users")
	public List<User>retriveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id) throws UserNotFoundException {
		User user =service.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id-"+id);
			return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Validated @RequestBody User user) {
		User savedUser =service.save(user);
		URI location =ServletUriComponentsBuilder.
		fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		
		
        return ResponseEntity.created(location).build();
	
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) throws UserNotFoundException {
		User user = service.deleteById(id);
		
		if(user==null)
			throw new UserNotFoundException("id-"+ id);	
	}
	
	
}


package com.example.demo.user;

import java.util.Map;
import java.util.HashMap;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.ApiError;
import com.example.demo.shared.GenericResponse;


import jakarta.validation.Valid;


@RestController
public class UserController {
	//private static final Logger log=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@PostMapping("/api/1.0/users")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
		//log.info(user.toString());
		ApiError error=new ApiError(400,"Validation error","/api/1.0/users");
		Map<String,String>validationErrors=new HashMap<>();
		String username=user.getUsername();	
		String surname=user.getSurname();	
		if(username==null || username.isEmpty()) {
			validationErrors.put("username", "username cannot be null");
		}
		if(surname==null || surname.isEmpty()) {
			
			validationErrors.put("surname", "surname cannot be null");
		}
		if(validationErrors.size()>0) {
			error.setValidationErrors(validationErrors);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
			
		}
		
		userService.save(user);
		return ResponseEntity.ok(new GenericResponse("user created"));
		
		 
		
		
		
	}

}
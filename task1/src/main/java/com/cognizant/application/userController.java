package com.cognizant.application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {
	
	@Autowired
	public userControllerRepository userRepo;
	
	/* 1. POST ->http://localhost:8080/user ->Accept the Request Body in theXML Format and return the 
	created user detail in the response in JSON format*/
	@PostMapping(consumes= {MediaType.APPLICATION_XML_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<user>> postDetails(@RequestBody user userDetails)
	{ 
		List<user> ua=null;
	   try {
		  userRepo.save(userDetails);
		  ua=userRepo.findAll();
	   }
	   catch(Exception e) {
		   return new ResponseEntity<List<user>>(ua,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   return new ResponseEntity<List<user>>(ua,HttpStatus.OK);
	}
	@GetMapping(path="/{id}",produces= {MediaType.APPLICATION_XML_VALUE} )
	public Optional<user> getUserDetails(@PathVariable String id)
	{
		Optional< user> ua=null;
		try {
	         if(userRepo.findById(id)!=null) {
	        	 ua= userRepo.findById(id);
	        	 return ua;
	        	 
	         }
		}
		catch(Exception e) {
	         return ua;
		}
		return ua;
	}
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<user>> getUserDetails(){
		List<user> ua=null;
		ua=userRepo.findAll();
		return new ResponseEntity<List<user>>(ua,HttpStatus.OK);
	}
	@PutMapping(path="/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public Optional<user> postDetails(@PathVariable String id,@RequestBody user userDetails)
	{    Optional<user> ua=null;
		try
		{
			if(userRepo.findById(id)!=null) 
			{
				userRepo.save(userDetails);
				ua=userRepo.findById(id);
			}
		}
		catch(Exception e) {
			return   ua;
		}
		return ua;
		
	}
	@DeleteMapping(path="/{id}",produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Optional<user>> deleteUser(@PathVariable String id)
	{    Optional<user> ua=null;
		try {
		if(userRepo.findById(id)!= null) {
			
			ua=userRepo.findById(id);
			userRepo.deleteById(id);
			
		}
	}
		catch(Exception e) {
			return new ResponseEntity<Optional<user>>(ua,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Optional<user>>(ua,HttpStatus.OK);
	}
	@DeleteMapping()
	public ResponseEntity<String> deleteAllUser() {
		userRepo.deleteAll();
		return new ResponseEntity<String>("user deleted",HttpStatus.OK);
	}
	
	
}



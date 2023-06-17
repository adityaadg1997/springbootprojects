package com.jpa.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entity.User;


@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		 
		//create single user
		  
//		User user = new User();
//		user.setName("Aditya");
//		user.setCity("Kolkata");
//		user.setStatus("I'm a Java Programmer and I'm Active Now");
//		
//		User user2 = userRepository.save(user);
//		
//		System.out.println(user2);
		
		
		//create multiple user
//		User user = new User();
//		user.setName("Archit");
//		user.setCity("Uttar Pradesh");
//		user.setStatus("He Is Working as a Java developer");
//		
//		User user2 = new User();
//		user2.setName("Gaurav");
//		user2.setCity("Delhi");
//		user2.setStatus("He Is Inactive");
//		
//		List<User> userList = new ArrayList<>();
//		userList.add(user);
//		userList.add(user2);
//		
//		
//		Iterable<User> results = userRepository.saveAll(userList);
//		 
//		 results.forEach(item -> {
//			 System.out.println(item);
//		 });
		 
// update the user id 53
//		Optional<User> optional = userRepository.findById(53);
//		User user = optional.get();
//		user.setName("Gaurav Sharma");
//		
//		User save = userRepository.save(user);
//		System.out.println(save);
		
//how to get the data
//		
//		Iterable<User> results = userRepository.findAll();
//		
//		results.forEach(item -> {
//			System.out.println(item);
//		});
		
//how to delete the data 
		//deleting a single data
//		userRepository.deleteById(53);
//		System.out.println("deleted......");
		
		//delete all at once
		Iterable<User> allUser = userRepository.findAll();
		allUser.forEach(item -> System.out.println(item));
		userRepository.deleteAll(allUser);
		
		 
		 
		 
	}

}

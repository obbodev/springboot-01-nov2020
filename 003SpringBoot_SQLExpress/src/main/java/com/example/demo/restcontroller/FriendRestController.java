package com.example.demo.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FriendEntity;
import com.example.demo.pojo.Friend;
import com.example.demo.service.FriendService;

@RestController
public class FriendRestController {
	
	@Autowired
	private FriendService friendService;
	

	//@RequestMapping("/")
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String welcome() {
		return "Welcome to Spring Boot Version 2.4.0.0";
	}
	
	@RequestMapping("/welcome")
	public String welcome2() {
		return "Creating REST API's with Spring Boot with Devtools!!!!";
	}
	
	
	@GetMapping("/friends/all")
	public List<FriendEntity> getAllFriends() {
		return friendService.getAllFriends();
	}
	
	@PostMapping("/friends/add")
	public List<FriendEntity> addFriend(@RequestBody Friend f){
		return friendService.addFriend(f);	
	}
	
	@GetMapping("/friends/get/{id}")
	public FriendEntity getFriendById(@PathVariable int id) {
			return friendService.getFriendById(id);
	}
	
	@PutMapping("/friends/update/{id}")
	public List<FriendEntity> updateFriendById(@PathVariable int id, @RequestBody Friend f ){
		return friendService.updateFriendById(id, f);
	}
	
	@GetMapping("/friends/location/{location}")
	public List<FriendEntity> findByLocation(@PathVariable String location){
		return friendService.findByLocation(location);
	}
	
	
	
}

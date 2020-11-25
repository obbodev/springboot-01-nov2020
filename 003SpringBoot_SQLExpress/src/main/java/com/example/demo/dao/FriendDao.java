package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FriendEntity;
import com.example.demo.pojo.Friend;
import com.example.demo.repository.FriendRepository;


@Repository
public class FriendDao {
	
	@Autowired
	private FriendRepository friendRepository;
	
	
	public List<FriendEntity> getAllFriends() {
		// TODO Auto-generated method stub
		return friendRepository.findAll();
	}
	
	public List<FriendEntity> addFriend(Friend f){
		
		FriendEntity fe = new FriendEntity();
		fe.setName(f.getName());
		fe.setLocation(f.getLocation());
		
		friendRepository.save(fe);
		
		return friendRepository.findAll();
	}

	public FriendEntity getFriendById(int id) {
		// TODO Auto-generated method stub
		Optional<FriendEntity> optionalFe =   friendRepository.findById(id);
		if(optionalFe.isPresent()) {
			return optionalFe.get();
		}else {
			return new FriendEntity();
		}
		
	}

	public List<FriendEntity> updateFriendById(int id, Friend f) {
		// TODO Auto-generated method stub
		Optional<FriendEntity> feo = friendRepository.findById(id);
		if(feo.isPresent()) {
			FriendEntity fe = feo.get();
			fe.setName(f.getName());
			fe.setLocation(f.getLocation());
			friendRepository.saveAndFlush(fe);
			return friendRepository.findAll();
		}
		
		return new ArrayList<FriendEntity>();
		
		
	}

	public List<FriendEntity> findByLocation(String location) {
		// TODO Auto-generated method stub
		return friendRepository.findByLocation(location);
	}

}

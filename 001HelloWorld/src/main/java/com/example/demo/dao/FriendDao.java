package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Friend;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

@Repository
public class FriendDao {
	
	private List<Friend> friends = new ArrayList<Friend>();
	
	public FriendDao() {
		Friend f1 = new Friend(1, "OBB", "Chennai");
		Friend f2 = new Friend(2, "CAS", "Bengaluru");
		Friend f3 = new Friend(3, "OWIOH", "Japan");
		Friend f4 = new Friend(4, "Garage", "Chennai");
		
		friends.add(f1);
		friends.add(f2);
		friends.add(f3);
		friends.add(f4);
	}

	public List<Friend> getAllFriends() {
		// TODO Auto-generated method stub
		return friends;
	}
	
	public List<Friend> addFriend(Friend f){
		friends.add(f);
		return friends;
	}

	public Friend getFriendById(int id) {
		// TODO Auto-generated method stub
		for (Friend friend : friends) {
			if(friend.getId() == id) {
				return friend;
			}
		}
		return new Friend();
	}

	public List<Friend> updateFriendById(int id, Friend f) {
		// TODO Auto-generated method stub
		for (Friend friend : friends) {
			if(friend.getId() == id) {
				friend.setName(f.getName());
				friend.setLocation(f.getLocation());
				return friends;
			}
		}
		
		return new ArrayList<Friend>();
		
		
	}

}

package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.bean.*;

public interface UserDAO {
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
	
	public User findUserByUsername(String username);	
	
	public ArrayList<User> findUserByKeyword(String keyword);
	
	//Before insertion , check whether the friendship already exists.
	public void addFriend(Friend friend);
	
	//Before deletion , check whether the friendship already exists. 
	public void deleteFriend(Friend friend);
	
	public void deleteFriendByUsernames(String username1, String username2);
	
	public void deleteFriendByIdFriend(int idfriend);
	/**
	 * Check whether two users are already friends.
	 * @param user1
	 * @param user2
	 * @return true if the two users are already friends in the database.
	 */
	public Friend findFriendship(String user1, String user2);

	//See Java API document for the usage for ArrayList.
	//public ArrayList<User> findFriendsByUsername(String username);
	public ArrayList<User> findFriendsByUsername(String username);
	
	public Friend findFriendByIdfriend(int Idfriend);
	
	public int countFriendByUsername(String username);
	
	public void addRequest(Request request);
	public void deleteRequest(Request request);
	public void updateRequest(Request request);
	public ArrayList<Request> findRequestByInvitor(String invitor);
	public ArrayList<Request> findRequestByAnsweror(String answeror);
	public int countRequestByAnsweror(String answeror);
	public Request findRequestByInvitorAnsweror(String invitor, String answeror);
	

	
}

package com.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;

import com.util.ErrorType;
import com.bean.*;
import com.dao.UserDAO;
import com.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;


	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void save(User user)
	{
		this.userDAO.saveUser(user);
	}

	@Override
	public ErrorType update(User user)
	{
		try {
			this.userDAO.updateUser(user);
		} catch (HibernateException he) {
			return ErrorType.DELETE_ERROR;
		} 
		return ErrorType.NO_ERROR;

	}

	@Override
	public ErrorType loginUser(String username, String password) {
		User user = this.userDAO.findUserByUsername(username);
		if (user == null){
			return ErrorType.USER_NOT_EXIST;
		} else if (!user.getPassword().equals(password)) {
			return ErrorType.PASSWORD_NOT_MATCH;
		}
		else {
		   return ErrorType.NO_ERROR;	
		}
			
	}	
	
	@Override
	public boolean usernameExsit(String username) {
		User user = this.userDAO.findUserByUsername(username);
		if (user == null ) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<User> findFriendsByUsername(String username) {
		ArrayList<User> friends = this.userDAO.findFriendsByUsername(username);
		return friends;
	}

	@Override
	public ArrayList<User> findUserByKeyword(String keyword){
		ArrayList<User> users = userDAO.findUserByKeyword(keyword);
		return users;
	}
	
	@Override
	public int addFriend(String user1, String user2) {
		Friend friend = new Friend();
		User u1 = this.userDAO.findUserByUsername(user1);
		User u2 = this.userDAO.findUserByUsername(user2);
		friend.setUser1(u1);
		friend.setUser2(u2);
		Friend friendship = this.userDAO.findFriendship(user1, user2);
		if (friendship == null) {
			this.userDAO.addFriend(friend);
			return friend.getIdfriend();			
		}
		return ErrorType.FRIENDSHIP_EXISTED.compareTo(ErrorType.NO_ERROR);				
	}
    
	//OK:
	@Override
	public ErrorType deleteFriend(String user1, String user2) {
		Friend friend = userDAO.findFriendship(user1, user2);
		if(friend==null)
			return ErrorType.FRIEND_NOT_EXISTED;
		try {
			this.userDAO.deleteFriendByUsernames(user1,user2);
		} catch (HibernateException he) {
			return ErrorType.DELETE_ERROR;
		} //addFriend and Delete Friend use two different error-handling methods.
		return ErrorType.NO_ERROR;
	}

	@Override
	public boolean checkFriendshipExist(String user1, String user2) {
		return (this.userDAO.findFriendship(user1, user2) != null);
	}
	
	@Override
	public int countFriendByUsername(String username){
		int i = userDAO.countFriendByUsername(username);
		return i;
	}
	
	@Override
	public ErrorType signInUser(String username, String password, String email){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setTime(new Date());
		User user1 = this.userDAO.findUserByUsername(username);
		if(user1 == null){
			this.userDAO.saveUser(user);
			return ErrorType.NO_ERROR;
		}
		return ErrorType.USERNAME_EXISTED;
	}
	
	@Override
	public ErrorType addRequest(String invitor, String answeror){
		Request request = new Request();
		User u1 = this.userDAO.findUserByUsername(invitor);
		if(u1 == null)
			return ErrorType.USER_NOT_EXIST;
		
		User u2 = this.userDAO.findUserByUsername(answeror);
		if(u2 == null)
			return ErrorType.USER_NOT_EXIST;
		
		Request request1 = this.userDAO.findRequestByInvitorAnsweror(invitor, answeror);
		if(request1 != null)
			return ErrorType.REQUEST_EXISTED;
		
		request.setInvitor(u1);
		request.setAnsweror(u2);
		request.setTime(new Date());
		
		try {
			this.userDAO.addRequest(request);
			return ErrorType.NO_ERROR;
		} catch (HibernateException he) {
			he.printStackTrace();
			return ErrorType.ADD_REQUEST_ERROR;
		} //addFriend and Delete Friend use two different error-handling methods.

		

			
	}
	
	@Override
	public ErrorType deleteRequest(String invitor, String answeror){
		Request request = userDAO.findRequestByInvitorAnsweror(invitor, answeror);
		if(request == null)
			return ErrorType.REQUEST_NOT_EXISTED;
		else{
			try {
				this.userDAO.deleteRequest(request);
			} catch (HibernateException he) {
				return ErrorType.DELETE_ERROR;
			} 
			return ErrorType.NO_ERROR;
		}
	}
	
	@Override
	public ArrayList<Request> findRequestByInvitor(String invitor){
		ArrayList<Request> requests = userDAO.findRequestByInvitor(invitor);
		return requests;
	}
	
	@Override
	public ArrayList<Request> findRequestByAnsweror(String answeror){
		ArrayList<Request> requests = userDAO.findRequestByAnsweror(answeror);
		return requests;
	}
	
	@Override
	public int countRequestByAnsweror(String answeror){
		int i = userDAO.countRequestByAnsweror(answeror);
		return i;
	}
	
	@Override
	public Request findRequestByInvitorAnsweror(String invitor, String answeror){
		Request request = userDAO.findRequestByInvitorAnsweror(invitor, answeror);
		return request;
	}

}

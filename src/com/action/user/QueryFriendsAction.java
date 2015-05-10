 package com.action.user;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.bean.Friend;
import com.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

public class QueryFriendsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7769955847195086167L;

	/**
	 * 
	 */
	private UserService service;
    ArrayList<User> friendList;





	public UserService getService() {
		return service;
	}



	public void setService(UserService service) {
		this.service = service;
	}



	public ArrayList<User> getFriendList() {
		return friendList;
	}



	public void setFriendList(ArrayList<User> friendList) {
		this.friendList = friendList;
	}



	Map session = ActionContext.getContext().getSession();
	String username = session.get("username").toString();

	
	
//	@Override
//	@Transactional
//	public String execute() throws Exception { //写来测试= =		
//		return null;		
//	}
	
	@Transactional
	public String queryFriendsByUsername() {	
		
		this.friendList = this.service.findFriendsByUsername("dongtao");
		
		if (this.friendList!=null) 
			return SUCCESS;
		
		else
			return "No friend";				
	}
	
	

	@Transactional
	public int countFriendsByUsername() {
		this.friendList = this.service.findFriendsByUsername("dongtao");
		if(this.friendList != null)
			return this.friendList.size();
		else
			return 0;		
	}
}

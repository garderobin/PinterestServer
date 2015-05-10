package com.action.user;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

public class AddFriendAction extends ActionSupport {
/**
	 * 
	 */
	private static final long serialVersionUID = -727918086087979915L;
private UserService service;
	private String friendname;
	private int idfriend;

	
	public UserService getService() {
		return service;
	}


	public void setService(UserService service) {
		this.service = service;
	}


	public String getFriendname() {
		return friendname;
	}


	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}


	public int getIdfriend() {
		return idfriend;
	}


	public void setIdfriend(int idfriend) {
		this.idfriend = idfriend;
	}


	@Override
	@Transactional
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		idfriend =  this.service.addFriend(username, friendname);
		if (idfriend < 0) {
			return INPUT;
		}
		this.service.deleteRequest(friendname, username);
		return SUCCESS;		
	}
	

	@Transactional
	public String inviteFriendRequest() {
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		this.service.addRequest(username, friendname);
//		if (idfriend < 0) {
//			return INPUT;
//		}
		//this.service.deleteRequest(friendname, username);
		
		return SUCCESS;		
	}
	
}
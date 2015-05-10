package com.action.user;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.bean.Board;
import com.bean.Picture;
import com.bean.User;
import com.bean.Follow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import com.util.BoardStat;
import com.util.ErrorType;
import com.util.FriendStat;

public class FriendQueryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6916811961752774806L;
	
	private UserService service;
	private ArrayList<User> userlist;
	private String keyword;
	private ArrayList<User> friendlist;
	private FriendStat friendstat;
	private int friendExist;
	private String friendOfCurUser;

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	public ArrayList<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(ArrayList<User> userlist) {
		this.userlist = userlist;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public ArrayList<User> getFriendlist() {
		return friendlist;
	}

	public void setFriendlist(ArrayList<User> friendlist) {
		this.friendlist = friendlist;
	}

	public FriendStat getFriendstat() {
		return friendstat;
	}

	public void setFriendstat(FriendStat friendstat) {
		this.friendstat = friendstat;
	}

	@Transactional
	public String queryUserByKeyword() {		
		this.userlist = this.service.findUserByKeyword(keyword);
		if (userlist!=null)			
			return SUCCESS;	
		else
			return "No user";		
	}

	@Transactional
	public String queryFriendByUsername() {
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		this.friendlist = this.service.findFriendsByUsername(username);
		if(friendlist!=null)
			return SUCCESS;
		else
			return "No friend";
		
	}
	
	@Transactional
	public String queryFriendExist() {
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		friendExist = (service.checkFriendshipExist(username, friendOfCurUser) ? 1 : 0);
		return SUCCESS;
		
	}


	@Transactional
	public String countFriendAndRequestByUsername() {		
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		this.friendstat.setFriendcount(this.service.countFriendByUsername(username));
		this.friendstat.setRequestcount(this.service.countRequestByAnsweror(username));
			return SUCCESS;			
	}

	public int getFriendExist() {
		return friendExist;
	}

	public void setFriendExist(int friendExist) {
		this.friendExist = friendExist;
	}

	public String getFriendOfCurUser() {
		return friendOfCurUser;
	}

	public void setFriendOfCurUser(String friendOfCurUser) {
		this.friendOfCurUser = friendOfCurUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}


package com.action.user;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

public class DeleteFriendAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -411424056949906189L;
	private String friendname;
	private UserService service;





	public String getFriendname() {
		return friendname;
	}


	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}


	public UserService getService() {
		return service;
	}


	public void setService(UserService service) {
		this.service = service;
	}


	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		switch(this.service.deleteFriend(username, friendname)) {
		case FRIEND_NOT_EXISTED:
			addFieldError("message", "Friend not exists.");
			return "friend not exists";
		case DELETE_ERROR:
			addFieldError("message", "Error during friend deleting");
			return "delete friend error";
		case NO_ERROR:		
			return SUCCESS;
		default:
			return "default";		
		}	
	}
}

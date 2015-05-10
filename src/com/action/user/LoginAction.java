 package com.action.user;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1306001442671662897L;
	private String username;
	private String password;
	private UserService service;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String execute() throws Exception {
		switch(this.service.loginUser(username, password)) {
		case USER_NOT_EXIST:
			addFieldError("message", "Username not exists. Please sign up first!");
			return LOGIN;
		case PASSWORD_NOT_MATCH:
			addFieldError("message", "Username and password mismatch.");
			return INPUT;
		case NO_ERROR:
			Map session = ActionContext.getContext().getSession();
			session.put("username", username);			
			return SUCCESS;
		}		
		return SUCCESS;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
	
}

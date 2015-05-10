package com.action.user;

import java.util.Map;

import com.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

public class ModifyUserInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6532572051152947101L;
	private UserService service;
	private User user;
	private String old_password;
	private String email;
	private String password;
	private String confirm_password;
	public UserService getService() {
		return service;
	}
	public void setService(UserService service) {
		this.service = service;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOld_password() {
		return old_password;
	}
	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		switch(this.service.update(user)) {
		case UPDATE_ERROR:
			return "error";
		case NO_ERROR:		
			return SUCCESS;
		default:
			return "default";		
		}		
	}
	
}

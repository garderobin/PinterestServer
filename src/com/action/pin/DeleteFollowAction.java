package com.action.pin;

import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;

public class DeleteFollowAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -435011910933019676L;
	private int idfollow;
	private PinService service;
	public int getIdfollow() {
		return idfollow;
	}
	public void setIdfollow(int idfollow) {
		this.idfollow = idfollow;
	}
	public PinService getService() {
		return service;
	}
	public void setService(PinService service) {
		this.service = service;
	}

	@Override
	public String execute() throws Exception {
		switch(this.service.deleteFollow(idfollow)) {
		case FOLLOW_NOT_EXISTED:
			addFieldError("message", "Follow not exists.");
			return "follow not exists";
		case DELETE_ERROR:
			addFieldError("message", "Error during follow deleting");
			return "delete follow error";
		case NO_ERROR:		
			return SUCCESS;
		default:
			return "default";		
		}	
	}
}

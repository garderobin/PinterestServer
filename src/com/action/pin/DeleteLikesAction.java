package com.action.pin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;
import com.util.ErrorType;

public class DeleteLikesAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4851069683781635988L;
	private int picnum;
	private int idlikes;
	private ErrorType er;
	private PinService service;
	

	public int getIdlikes() {
		return idlikes;
	}


	public void setIdlikes(int idlikes) {
		this.idlikes = idlikes;
	}


	public PinService getService() {
		return service;
	}


	public void setService(PinService service) {
		this.service = service;
	}


	@Override
	public String execute() throws Exception {
	
//		switch(this.service.deleteLikes(idlikes)) {
//		case LIKES_NOT_EXISTED:
//			addFieldError("message", "likes not exists.");
//			return "likes not exists";
//		case DELETE_ERROR:
//			addFieldError("message", "Error during likes deleting");
//			return "delete likes error";
//		case NO_ERROR:		
//			return SUCCESS;
//		default:
//			return "default";		
//		}	
		
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		er = this.service.deleteLikesByUsernamePicnum(username, picnum);
		return SUCCESS;		
	}


	public int getPicnum() {
		return picnum;
	}


	public void setPicnum(int picnum) {
		this.picnum = picnum;
	}
}
package com.action.pin;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;

public class AddLikesAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 735748742508236064L;
	private PinService service;
	private int picnum;
	private int idlikes;

	
	@Override
	@Transactional
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		idlikes =  this.service.addLikes(username, picnum);
		if (idlikes < 0) {
			return INPUT;
		}
		return SUCCESS;		
	}


	public PinService getService() {
		return service;
	}


	public void setService(PinService service) {
		this.service = service;
	}


	public int getPicnum() {
		return picnum;
	}


	public void setPicnum(int picnum) {
		this.picnum = picnum;
	}


	public int getIdlikes() {
		return idlikes;
	}


	public void setIdlikes(int idlikes) {
		this.idlikes = idlikes;
	}

	
}


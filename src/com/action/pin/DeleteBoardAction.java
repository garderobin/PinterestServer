 package com.action.pin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;
import com.util.ErrorType;

public class DeleteBoardAction extends ActionSupport {
	
	private static final long serialVersionUID = -8048334825837552668L;
	private int bid;
	private PinService service;
	
	
	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public PinService getService() {
		return service;
	}


	public void setService(PinService service) {
		this.service = service;
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String execute() throws Exception {
		switch(this.service.deleteBoard(bid)) {
		case DELETE_ERROR:
			addFieldError("message", "Error during deleting");
			return "delete error";
		case BOARD_NOT_EXISTED:
			addFieldError("message", "Board not exists.");
			return "board not exists";
		case NO_ERROR:		
			return SUCCESS;
		default:
			return "default";		
		}			
	}
	
}

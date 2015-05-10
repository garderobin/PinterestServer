 package com.action.pin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;

public class EditBoardAction extends ActionSupport {
	
	
/**
	 * 
	 */
	private static final long serialVersionUID = -9189380459256256957L;
	private int bid;
	private String bname;
	private String info;
	private PinService service;
	
	@Override
	public String execute() throws Exception {
		switch(this.service.updateBoard(bid, bname, info)) {
		case UPDATE_ERROR:
			addFieldError("message", "Error during updating");
			return "update error";
		case BOARD_EXISTED:
			addFieldError("message", "Board name exists.");
			return "board name exists";
		case NO_ERROR:		
			return SUCCESS;
		default:
			return "default";		
		}		
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}


	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public PinService getService() {
		return service;
	}

	public void setService(PinService service) {
		this.service = service;
	}

    




	
	
}

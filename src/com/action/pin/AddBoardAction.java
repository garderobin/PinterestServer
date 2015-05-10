 package com.action.pin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;
import com.util.ErrorType;

public class AddBoardAction extends ActionSupport {
	
	private static final long serialVersionUID = -8048334825837552668L;
	private String bname;
	private String info;
	private int bid;
	private PinService service;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		int i = this.service.addBoard(username, bname, info);
		if(i<0){
			ErrorType b= ErrorType.values()[i+28];
		    switch(b) {
		      case USER_NOT_EXIST:
			    addFieldError("message", "Username not exists. Please sign up first!");
			    return "user not exists";
		      case BOARD_EXISTED:
			    addFieldError("message", "Board name exists.");
			    return "board name exists";
		      case NO_ERROR:		
			    return SUCCESS;
		      default:
			    return "default";		
		    }
		}
		else{		
			//return String.valueOf(i);
			return SUCCESS;
		}				
	}



	public void setBname(String bname) {
		this.bname = bname;
	}


	public void setInfo(String info) {
		this.info = info;
	}



	public void setService(PinService service) {
		this.service = service;
	}



	public int getBid() {
		return bid;
	}



	public void setBid(int bid) {
		this.bid = bid;
	}


	
	
}

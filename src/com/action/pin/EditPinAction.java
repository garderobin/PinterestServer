package com.action.pin;

import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;
import java.util.Date;

public class EditPinAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8097225245209437601L;
	private int pinid;
	private int bid;
	private int picnum;
	private String note;
	//private Date time;
	private PinService service;
    

	public int getPinid() {
		return pinid;
	}


	public void setPinid(int pinid) {
		this.pinid = pinid;
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public int getPicnum() {
		return picnum;
	}


	public void setPicnum(int picnum) {
		this.picnum = picnum;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}

	public PinService getService() {
		return service;
	}


	public void setService(PinService service) {
		this.service = service;
	}


	@Override
	public String execute() throws Exception {
		System.out.println(">>>>>>>> Enter action!<<<<<<<<<<");
		switch(this.service.updatePin(pinid, bid, note)) {
		case PIN_EXISTED:
			addFieldError("message", "Can not get into the destination board");
			return "cannot change board";
		case PIN_NOT_EXISTED:
			addFieldError("message", "Pin not exists.");
			return "pin not exists";
		case UPDATE_ERROR:
			addFieldError("message", "Error during updating");
			return "update error";
		case NO_ERROR:		
			return SUCCESS;
		default:
			return "default";		
		}	
	}

}

package com.action.pin;

import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;

public class RepinAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4962340925266440529L;
	private int bid;
	private int picnum;
	private String note;
	private int pinid;
	private int repin;
	private int newPinid;
	private PinService service;


	@Override
	public String execute() throws Exception {
		newPinid = this.service.addPin(bid, picnum, note, repin);
		if (newPinid < 0) {
			return INPUT;
		}
		return SUCCESS;		
	}

	
	public void setBid(int bid) {
		this.bid = bid;
	}


	public void setPicnum(int picnum) {
		this.picnum = picnum;
	}


	public void setNote(String note) {
		this.note = note;
	}

	
	public void setService(PinService service) {
		this.service = service;
	}


	public int getPinid() {
		return pinid;
	}

	
	public void setRepin(int repin) {
		this.repin = repin;
	}


	public int getNewPinid() {
		return newPinid;
	}


	public void setNewPinid(int newPinid) {
		this.newPinid = newPinid;
	}


}

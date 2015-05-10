package com.action.pin;

import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;

public class AddPinAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -979722933097248167L;
	private int bid;
	private int picnum;
	private String note;
	private int pinid;
	private PinService service;
	


	@Override
	public String execute() throws Exception {
		pinid = this.service.addPin(bid, picnum, note, -1);
		if (pinid < 0) {
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


}

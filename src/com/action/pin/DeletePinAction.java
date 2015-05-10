package com.action.pin;

import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;
import java.util.Date;

public class DeletePinAction extends ActionSupport {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4139006743363429218L;

	private int pinid;
	private PinService service;



	public int getPinid() {
		return pinid;
	}



	public void setPinid(int pinid) {
		this.pinid = pinid;
	}



	public PinService getService() {
		return service;
	}



	public void setService(PinService service) {
		this.service = service;
	}



	@Override
	public String execute() throws Exception {
		switch(this.service.deletePin(pinid)) {
		case DELETE_PICTURE_ERROR:
			addFieldError("message", "Error during deleting picture");
			return "delete picture error";
		case PIN_NOT_EXISTED:
			addFieldError("message", "Pin not exists.");
			return "pin not exists";
		case DELETE_ERROR:
			addFieldError("message", "Error during pin deleting");
			return "delete pin error";
		case NO_ERROR:		
			return SUCCESS;
		default:
			return "default";		
		}	
	}

}

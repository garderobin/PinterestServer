 package com.action.pin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;
import com.util.ErrorType;

import java.util.ArrayList;

import com.bean.Pin;
import com.util.PinStat;

public class TakePinByBidAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 225858865100774429L;
	private ArrayList<Pin> pinlist;
	private PinService service;
	private ArrayList<PinStat> pinStatList;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();		
		this.pinlist = this.service.takePinByBidOrder();
		if(pinlist != null){
			pinStatList = this.service.pinStatListByPinList(username, pinlist);
			return "success";
		}
		else
			return "No pin";
	}

	

	public ArrayList<PinStat> getPinStatList() {
		return pinStatList;
	}



	public void setPinStatList(ArrayList<PinStat> pinStatList) {
		this.pinStatList = pinStatList;
	}



	public ArrayList<Pin> getPinlist() {
		return pinlist;
	}



	public void setPinlist(ArrayList<Pin> pinlist) {
		this.pinlist = pinlist;
	}



	public PinService getService() {
		return service;
	}

	public void setService(PinService service) {
		this.service = service;
	}
}

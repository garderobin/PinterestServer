 package com.action.pin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;
import com.util.ErrorType;
import java.util.ArrayList;
import com.bean.Comment;
public class QueryCommentByPinidAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3963052825469921521L;
	private int pinid;
	private ArrayList<Comment> commentlist;
	private PinService service;
	
	public int getPinid() {
		return pinid;
	}

	public void setPinid(int pinid) {
		this.pinid = pinid;
	}

	public ArrayList<Comment> getCommentlist() {
		return commentlist;
	}

	public void setCommentlist(ArrayList<Comment> commentlist) {
		this.commentlist = commentlist;
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
		commentlist = this.service.findCommentByPinid(pinid);
		return SUCCESS;				
	}
	
}
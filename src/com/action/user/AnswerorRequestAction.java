package com.action.user;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.bean.Request;
import com.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import com.util.ErrorType;

public class AnswerorRequestAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5785085330399586048L;
	private UserService service;
	private String invitor;
	private int idRequest;
	private int count;
	private Request request;
	private ArrayList<Request> requests;


	public UserService getService() {
		return service;
	}


	public void setService(UserService service) {
		this.service = service;
	}


	public int getIdRequest() {
		return idRequest;
	}


	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}


	public String getInvitor() {
		return invitor;
	}


	public void setInvitor(String invitor) {
		this.invitor = invitor;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public ArrayList<Request> getRequests() {
		return requests;
	}


	public void setRequests(ArrayList<Request> requests) {
		this.requests = requests;
	}


	public Request getRequest() {
		return request;
	}


	public void setRequest(Request request) {
		this.request = request;
	}


	
	@Transactional
	public String deleteRequestByAnsweror() {	
		Map session = ActionContext.getContext().getSession();
		String answeror = session.get("username").toString();
		ErrorType b = this.service.deleteRequest(invitor,answeror);
		switch(b) {
		      case DELETE_ERROR:
		    	  addFieldError("message", "error during deletion");
		    	  return "delete error";
		      case REQUEST_NOT_EXISTED:
		    	  addFieldError("message", "request not exists");
		    	  return "request not exists";  
		      case NO_ERROR:
		    	  addFieldError("message", "success");
		    	  return "success";  
		      default:
		    	  return "default";		
		    }			
	}
	
	@Transactional
	public String findRequestByAnsweror() {	
		Map session = ActionContext.getContext().getSession();
		String answeror = session.get("username").toString();
		requests = this.service.findRequestByAnsweror(answeror);
//		if(requests != null)
//			return "success";
//		else 
//			return "no request";
		return SUCCESS;
	}
	
	@Transactional
	public String countRequestByAnsweror() {	
		Map session = ActionContext.getContext().getSession();
		String answeror = session.get("username").toString();
		count = this.service.countRequestByAnsweror(answeror);
		return "success";

	}

}

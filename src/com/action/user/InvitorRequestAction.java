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

public class InvitorRequestAction extends ActionSupport {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5855298833167470348L;
	private UserService service;
	private String answeror;
	private int idRequest;
	private Request request;
	private ArrayList<Request> requests;


	public UserService getService() {
		return service;
	}


	public void setService(UserService service) {
		this.service = service;
	}


	public String getAnsweror() {
		return answeror;
	}


	public void setAnsweror(String answeror) {
		this.answeror = answeror;
	}


	public int getIdRequest() {
		return idRequest;
	}


	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}


	public Request getRequest() {
		return request;
	}


	public void setRequest(Request request) {
		this.request = request;
	}

	
	@Transactional
	public String addRequest() {	
		Map session = ActionContext.getContext().getSession();
		String invitor = session.get("username").toString();
		ErrorType b = this.service.addRequest(invitor,answeror);
		//request = this.service.findRequestByInvitorAnsweror(invitor, answeror);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>ErrorType: " + b);
		switch(b) {
		      case USER_NOT_EXIST:
		    	  addFieldError("message", "answeror not exists");
		    	  return "answeror not exists";
		      case REQUEST_EXISTED:
		    	  addFieldError("message", "request exists");
		    	  return "request exists";  
		      case NO_ERROR:
		    	  //addFieldError("message", "success");
		    	  return "success";  
		      case ADD_REQUEST_ERROR:
		    	  addFieldError("message", "error during adding request");
		    	  return "add request error"; 
		      default:
		    	  return "default";		
		    }			
	}
	
	@Transactional
	public String deleteRequestByInvitor() {	
		Map session = ActionContext.getContext().getSession();
		String invitor = session.get("username").toString();
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
	public String findRequstByInvitor() {	
		Map session = ActionContext.getContext().getSession();
		String invitor = session.get("username").toString();
		requests = this.service.findRequestByInvitor(invitor);
		if(requests != null)
			return "success";
		else 
			return "no request";
	}

}

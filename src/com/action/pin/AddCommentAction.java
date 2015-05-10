package com.action.pin;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;

public class AddCommentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -409041761988697583L;
	private PinService service;
	private String content;
	private int pinid;
	private int idcomment;

	
	@Override
	@Transactional
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		idcomment =  this.service.addComment(username, pinid, content);
		if (idcomment < 0) {
			System.out.println(">>>>>>>>>>>>>> idcomment(errorType): " + idcomment);
			return INPUT;
		}
		return SUCCESS;		
	}


	public PinService getService() {
		return service;
	}


	public void setService(PinService service) {
		this.service = service;
	}


	public int getPinid() {
		return pinid;
	}


	public void setPinid(int pinid) {
		this.pinid = pinid;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getIdcomment() {
		return idcomment;
	}


	public void setIdcomment(int idcomment) {
		this.idcomment = idcomment;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
}


package com.action.pin;

import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;

public class DeleteCommentAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5565081045745838484L;
	private int cid;
	private PinService service;
	

	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public PinService getService() {
		return service;
	}


	public void setService(PinService service) {
		this.service = service;
	}


	@Override
	public String execute() throws Exception {
		switch(this.service.deleteComment(cid)) {
		case COMMENT_NOT_EXISTED:
			addFieldError("message", "Comment not exists.");
			return "comment not exists";
		case DELETE_ERROR:
			addFieldError("message", "Error during comment deleting");
			return "delete comment error";
		case NO_ERROR:		
			return SUCCESS;
		default:
			return "default";		
		}	
	}
}

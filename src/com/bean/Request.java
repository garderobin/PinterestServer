package com.bean;
import java.util.Date;

public class Request {
	
	private int idrequest;
	private User invitor;
	private User answeror;
	private Date time;

	public Request() {
		
	}
	
	public Request(User invitor, User answeror) {
		this.invitor = invitor;
		this.answeror = answeror;
		this.time = new Date();
	}

	public Request(User invitor, User answeror, Date time) {
		this.invitor = invitor;
		this.answeror = answeror;
		this.time = time;
	}


	public int getIdrequest() {
		return idrequest;
	}



	public void setIdrequest(int idrequest) {
		this.idrequest = idrequest;
	}



	public User getInvitor() {
		return invitor;
	}

	public void setInvitor(User invitor) {
		this.invitor = invitor;
	}

	public User getAnsweror() {
		return answeror;
	}

	public void setAnsweror(User answeror) {
		this.answeror = answeror;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

    
	
    
}
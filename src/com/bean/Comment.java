package com.bean;

import java.util.Date;

public class Comment{

	private int cid;
	private User user ;
	private Pin pin;
	private String content;
	private Date time;
	
	
    public Comment(){
    	
    }
    public Comment(int cid, User user, Pin pin, String content, Date time){
    	this.cid = cid;
    	this.user = user;
    	this.pin = pin;
    	this.content = content;
    	this.time = time;
    }
    public Comment(User user, Pin pin, String content, Date time){
    	this.user = user;
    	this.pin = pin;
    	this.content = content;
    	this.time = time;
    }

	

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Pin getPin() {
		return pin;
	}
	public void setPin(Pin pin) {
		this.pin = pin;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((pin == null) ? 0 : pin.hashCode());
		return result;
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (	Comment) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (pin == null) {
			if (other.pin != null)
				return false;
		} else if (!pin.equals(other.pin))
			return false;
		return true;
	}
	
}

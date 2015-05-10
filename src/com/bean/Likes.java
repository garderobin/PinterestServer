package com.bean;

import java.util.Date;

public class Likes{
    private int idlikes;
	private User user;
	private Picture picture;
	private Date time;
	

	public Likes(){
		
	}
	public Likes(int idlikes, User user, Picture picture, Date time){
		this.idlikes = idlikes;
		this.user = user;
		this.picture = picture;
		this.time = time;
	}
	public Likes(User user, Picture picture, Date time){
		this.user = user;
		this.picture = picture;
		this.time = time;
	}
	

	public int getIdlikes() {
		return idlikes;
	}

	public void setIdlikes(int idlikes) {
		this.idlikes = idlikes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
}


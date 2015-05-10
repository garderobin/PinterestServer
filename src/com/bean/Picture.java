package com.bean;

import java.util.HashSet;

import java.util.Set;

public class Picture {
	private int picnum;
	private String url;
	private String sourceUrl; 
	private Set<Pin> pins = new HashSet<Pin>(0);	
	private Set<Likes> likes = new HashSet<Likes>(0);
	
    public Picture(){
    	
    }
    public Picture(int picnum, String url, String sourceUrl){
    	this.picnum = picnum;
    	this.url = url;
    	this.sourceUrl = sourceUrl;
    }
    public Picture(String url, String sourceUrl){
    	this.url = url;
    	this.sourceUrl = sourceUrl;
    }
    
	public int getPicnum() {
		return picnum;
	}

	public void setPicnum(int picnum) {
		this.picnum = picnum;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public Set<Pin> getPins() {
		return pins;
	}

	public void setPins(Set<Pin> pins) {
		this.pins = pins;
	}

	
	public Set<Likes> getLikes() {
		return likes;
	}

	public void setLikes(Set<Likes> likes) {
		this.likes = likes;
	}
	
	
}

package com.action.pin;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.bean.Picture;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;

public class QueryPictureAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -566661667918796793L;
	
	private int picnum;
	private String url;
	private String sourceUrl;
	private int bid;
	private String username;
	
	private ArrayList<Picture> picList;
	private Picture picture;
	private PinService service;
	
	
	@Transactional
	public String queryPictureByUsername() {
		picList = this.service.findPictureByUsername(username);
		return SUCCESS;
	}
	
	@Transactional
	public String queryPictureByBid() {
		picList = this.service.findPictureByBid(bid);
		return SUCCESS;
	}
	
	@Transactional
	public String queryPictureByLikes() {
		picList = this.service.findPictureByLikes(username);
		return SUCCESS;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<Picture> getPicList() {
		return picList;
	}

	public void setPicList(ArrayList<Picture> picList) {
		this.picList = picList;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public void setService(PinService service) {
		this.service = service;
	}
	
	
	
}

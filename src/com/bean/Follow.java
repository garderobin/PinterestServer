package com.bean;

import java.util.Date;

public class Follow {
	/**
	 * 
	 */
	private int idfollow;
	private User user;
	private Board board;
	private String stream;
	private Date time;
	
	public Follow(){
		
	}
	public Follow(int idfollow, User user, Board board, String stream, Date time){
		this.idfollow = idfollow;
		this.user = user;
		this.board = board;
		this.stream = stream;
		this.time = time;
	}
	
	public Follow(User user, Board board, String stream, Date time){
		this.user = user;
		this.board = board;
		this.stream = stream;
		this.time = time;
	}
	
	
	public int getIdfollow() {
		return idfollow;
	}
	public void setIdfollow(int idfollow) {
		this.idfollow = idfollow;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	

}

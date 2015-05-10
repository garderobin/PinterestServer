package com.util;

public class FriendStat {
	private int friendcount;
	private int requestcount;
	
	public FriendStat() {
		
	}
	
	public FriendStat(int friendcount, int requestcount) {
		this.friendcount = friendcount;
		this.requestcount = requestcount;
	}

	public int getFriendcount() {
		return friendcount;
	}

	public void setFriendcount(int friendcount) {
		this.friendcount = friendcount;
	}

	public int getRequestcount() {
		return requestcount;
	}

	public void setRequestcount(int requestcount) {
		this.requestcount = requestcount;
	}

	
	
}

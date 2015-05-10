package com.util;

public class BoardStat {
	private int bid;
	private int pinCount;
	private int followerCount;
	
	public BoardStat() {
		
	}
	
	public BoardStat(int bid, int pinCount, int followerCount) {
		this.bid = bid;
		this.pinCount = pinCount;
		this.followerCount = followerCount;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getPinCount() {
		return pinCount;
	}

	public void setPinCount(int pinCount) {
		this.pinCount = pinCount;
	}

	public int getFollowerCount() {
		return followerCount;
	}

	public void setFollowerCount(int followerCount) {
		this.followerCount = followerCount;
	}
	
	
}

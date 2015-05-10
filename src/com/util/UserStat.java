package com.util;

public class UserStat {
	
	private int boardCount;
	private int pinCount;
	private int likeCount;
	private int friendCount;
	private int followingCount;
	
	public UserStat() {
		
	}
	
	public UserStat(int bc, int pc, int lc, int frc, int foc) {
		this.boardCount = bc;
		this.pinCount = pc;
		this.likeCount = lc;
		this.friendCount = frc;
		this.followingCount = foc;
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	public int getPinCount() {
		return pinCount;
	}
	public void setPinCount(int pinCount) {
		this.pinCount = pinCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getFriendCount() {
		return friendCount;
	}
	public void setFriendCount(int friendCount) {
		this.friendCount = friendCount;
	}
	public int getFollowingCount() {
		return followingCount;
	}
	public void setFollowingCount(int followingCount) {
		this.followingCount = followingCount;
	}
	
	
}

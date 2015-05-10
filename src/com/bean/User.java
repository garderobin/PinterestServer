package com.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {
	private String username;
	private String password;
	private String email;
	private Date time;
	private Set<Board> boards = new HashSet<Board>(0);
	private Set<Likes> likes = new HashSet<Likes>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<Follow> follows = new HashSet<Follow>(0);
	private Set<Friend> friendsForUser1 = new HashSet<Friend>(0);
	private Set<Friend> friendsForUser2 = new HashSet<Friend>(0);
	private Set<Request> requestsForAnsweror = new HashSet<Request>(0);
	private Set<Request> requestsForInvitor = new HashSet<Request>(0);

	
	public User() {
		
	}
	
	public User(String username, String password, String email, Date time) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.time = time;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Set<Board> getBoards() {
		return boards;
	}

	public void setBoards(Set<Board> boards) {
		this.boards = boards;
	}

	public Set<Likes> getLikes() {
		return likes;
	}

	public void setLikes(Set<Likes> likes) {
		this.likes = likes;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Follow> getFollows() {
		return follows;
	}

	public void setFollows(Set<Follow> follows) {
		this.follows = follows;
	}

	public Set<Friend> getFriendsForUser1() {
		return friendsForUser1;
	}

	public void setFriendsForUser1(Set<Friend> friendsForUser1) {
		this.friendsForUser1 = friendsForUser1;
	}

	public Set<Friend> getFriendsForUser2() {
		return friendsForUser2;
	}

	public void setFriendsForUser2(Set<Friend> friendsForUser2) {
		this.friendsForUser2 = friendsForUser2;
	}

	public Set<Request> getRequestsForAnsweror() {
		return requestsForAnsweror;
	}

	public void setRequestsForAnsweror(Set<Request> requestsForAnsweror) {
		this.requestsForAnsweror = requestsForAnsweror;
	}

	public Set<Request> getRequestsForInvitor() {
		return requestsForInvitor;
	}

	public void setRequestsForInvitor(Set<Request> requestsForInvitor) {
		this.requestsForInvitor = requestsForInvitor;
	}

	
	

	
}

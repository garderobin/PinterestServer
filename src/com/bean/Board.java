package com.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Board {
	private int bid;
	private User user;
	private String bname;
	private String info;
	private Date time;
	private Set<Pin> pins = new HashSet<Pin>(0);
	private Set<Follow> follows = new HashSet<Follow>(0);

	public Board() {
		
	}
	
	public Board(int bid, User user, String bname, Date time) {
		this.bid = bid;
		this.user = user;
		this.bname = bname;
		this.time = time;		
	}
	
	public Board(User user, String bname, Date time) {
		this.user = user;
		this.bname = bname;
		this.time = time;		
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}
	
	

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Set<Pin> getPins() {
		return pins;
	}

	public void setPins(Set<Pin> pins) {
		this.pins = pins;
	}

	public Set<Follow> getFollows() {
		return follows;
	}

	public void setFollows(Set<Follow> follows) {
		this.follows = follows;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Board other = (	Board) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
	


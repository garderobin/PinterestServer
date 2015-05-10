package com.action.pin;

import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;
import com.service.UserService;
import com.util.BoardStat;
import com.util.UserStat;

public class QueryStatAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1607731456861911794L;
	private String username;
	//private int bid;
	private UserStat userStat;
	//private BoardStat boardStat;
	private PinService pinService;
	private UserService userService;
	
	@Transactional
	public String queryUserStatistic() {
		setUserStat(pinService.userBasicStatistic(username));
		return SUCCESS;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserStat getUserStat() {
		return userStat;
	}

	public void setUserStat(UserStat userStat) {
		this.userStat = userStat;
	}

	public PinService getPinService() {
		return pinService;
	}

	public void setPinService(PinService pinService) {
		this.pinService = pinService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	public BoardStat getBoardStat() {
//		return boardStat;
//	}
//
//	public void setBoardStat(BoardStat boardStat) {
//		this.boardStat = boardStat;
//	}
	
	
}

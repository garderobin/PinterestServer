package com.action.pin;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.bean.Board;
import com.bean.Picture;
import com.bean.User;
import com.bean.Follow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;
import com.util.BoardStat;
import com.util.ErrorType;

public class QueryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3333276204843821443L;
	
	private PinService service;
	private ArrayList<Picture> picturelist;
	private int picnum;
	private ArrayList<User> userlist;
	private ArrayList<Board> boardlist;
	private int bid;
	private ArrayList<String> streamlist;
	private String stream;
	private String oldstream;
	private Follow follow;
	private int boardCount;


	@Transactional
	public String queryPictureByLikes() {		
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		this.picturelist = this.service.findPictureByLikes(username);
		if (picturelist!=null)			
			return SUCCESS;	
		else
			return "No picture";		
	}
	
	@Transactional
	public String queryUserByLikes() {
		this.userlist = this.service.findUserByLikes(this.picnum);
		if(userlist!=null)
			return SUCCESS;
		else
			return "No user";
		
	}


	@Transactional
	public String queryBoardByFollow() {		
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		this.boardlist = this.service.findBoardByUsername(username);
		if (this.boardlist!=null)			
			return SUCCESS;
		else
			return "No board";				
	}
	
	
	@Transactional
	public String queryUserByFollow() {
		this.userlist = this.service.findUserByFollow(bid);
		boardCount = userlist.size();
		if (this.userlist!=null)
			return SUCCESS;
		else
			return "No user";		
	}
	
	
	@Transactional
	public String queryStreamByUsername() {
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		this.streamlist = this.service.findStreamByUsername(username);
		if (this.streamlist!=null)
			return SUCCESS;
		else
			return "No stream";
	}
	

	@Transactional
	public String queryBoardByStream() {
		this.boardlist = this.service.findBoardByStream(stream);
		if (this.boardlist!=null)
			return SUCCESS;
		else
			return "No board";
	}
	
	@Transactional
	public String updateFollow(){
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		ErrorType b = this.service.updateFollow(username, bid, stream);
	    switch(b) {
	      case FOLLOW_NOT_EXISTED:
		    addFieldError("message", "Follow not exists");
		    return "follow not exists";
	      case UPDATE_ERROR:
		    addFieldError("message", "Error during updating");
		    return "update follow error";
	      case NO_ERROR:		
		    return SUCCESS;
	      default:
		    return "default";		
	    }			
	}
	
	@Transactional
	public String queryFollowByUsernameBid() {
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		this.follow = this.service.findFollowByUsernameBid(username, bid);
		if (this.boardlist!=null)
			return SUCCESS;
		else
			return "No follow";
	}
	
	@Transactional
	public String changeFollowStream(){
		Map session = ActionContext.getContext().getSession();
		String username = session.get("username").toString();
		ErrorType b = this.service.changeFollowStream(username, oldstream, stream);
	    switch(b) {
	      case UPDATE_ERROR:
		    addFieldError("message", "Error during updating");
		    return "change stream error";
	      case NO_ERROR:		
		    return SUCCESS;
	      default:
		    return "default";		
	    }			
	}

	
	public PinService getService() {
		return service;
	}

	public void setService(PinService service) {
		this.service = service;
	}

	public ArrayList<Picture> getPicturelist() {
		return picturelist;
	}

	public void setPicturelist(ArrayList<Picture> picturelist) {
		this.picturelist = picturelist;
	}

	public int getPicnum() {
		return picnum;
	}

	public void setPicnum(int picnum) {
		this.picnum = picnum;
	}

	public ArrayList<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(ArrayList<User> userlist) {
		this.userlist = userlist;
	}

	public ArrayList<Board> getBoardlist() {
		return boardlist;
	}

	public void setBoardlist(ArrayList<Board> boardlist) {
		this.boardlist = boardlist;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public ArrayList<String> getStreamlist() {
		return streamlist;
	}

	public void setStreamlist(ArrayList<String> streamlist) {
		this.streamlist = streamlist;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getOldstream() {
		return oldstream;
	}

	public void setOldstream(String oldstream) {
		this.oldstream = oldstream;
	}

	public Follow getFollow() {
		return follow;
	}

	public void setFollow(Follow follow) {
		this.follow = follow;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
}

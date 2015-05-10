package com.action.pin;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.bean.Board;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;
import com.util.BoardStat;

public class QueryBoardAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1102697508491177891L;
	private PinService service;
	private int bid;
	private String username;
	private String bname;
	private String stream;
	private String info;
	private String keyword;
	private int picnum;		
	
	private Board board;
	private ArrayList<Board> boardList;
	private BoardStat boardStat;
	private int pinCount;
	private int followerCount;
	
	
	
//	@Override
//	@Transactional
//	public String execute() throws Exception { //写来测试= =		
//		return null;		
//	}
	
	@Transactional
	public String queryBoardByBid() {		
		setBoard(this.service.findBoardByBid(bid));
		if (this.board!=null) {			
			setBoardStat(service.boardBasicStatistic(bid));
			return SUCCESS;
			
		}
		else
			return "No board";		
	}
	
	@Transactional
	public String queryBoardStatistic() {
		setBoardStat(service.boardBasicStatistic(bid));
		return SUCCESS;
	}

	
	@SuppressWarnings("rawtypes")
	@Transactional
	public String queryBoardsByUsername() {		
//		Map session = ActionContext.getContext().getSession();
//		String username = session.get("username").toString();
		if (username == null) {
			Map session = ActionContext.getContext().getSession();
			username = session.get("username").toString();
		}
		this.boardList = this.service.findBoardByUsername(username);
		// For test
		Board b;
		if (this.boardList!=null) {
			for (int i = 0; i<boardList.size(); i++) {
				b = this.boardList.get(i);
				System.out.println(b.getBid() + "\t" + b.getBname() + "\t" + 
						b.getUser().getUsername() + "\t" + b.getInfo() + "\t");
			}
			return SUCCESS;
		}
		else
			return "No board";
				
	}
	
	
	@Transactional
	public String queryBoardsByStream() {
		this.boardList = this.service.findBoardByStream(stream);
		// For test
		Board b;
		if (this.boardList!=null) {
			for (int i = 0; i<boardList.size(); i++) {
				b = this.boardList.get(i);
				System.out.println(b.getBid() + "\t" + b.getBname() + "\t" + 
						b.getUser().getUsername() + "\t" + b.getInfo() + "\t");
			}
			return SUCCESS;
		}
		else
			return "No board";
		
	}
	
	
	@Transactional
	public String queryBoardsByKeyword() {
		this.boardList = this.service.findBoardByKeyword(keyword);
		// For test
		Board b;
		if (this.boardList!=null) {
			for (int i = 0; i<boardList.size(); i++) {
				b = this.boardList.get(i);
				System.out.println(b.getBid() + "\t" + b.getBname() + "\t" + 
						b.getUser().getUsername() + "\t" + b.getInfo() + "\t");
			}
			return SUCCESS;
		}
		else
			return "No board";
	}
	
	
	@Transactional
	public String queryBoardsByPicnum() {
		this.boardList = this.service.findBoardByPicnum(picnum);
		// For test
		Board b;
		if (this.boardList!=null) {
			for (int i = 0; i<boardList.size(); i++) {
				b = this.boardList.get(i);
				System.out.println(b.getBid() + "\t" + b.getBname() + "\t" + 
						b.getUser().getUsername() + "\t" + b.getInfo() + "\t");
			}
			return SUCCESS;
		}
		else
			return "No board";
	}
	
	
	
	
	public ArrayList<Board> getBoardList() {
		return boardList;
	}
	
	
	public void setService(PinService service) {
		this.service = service;
	}

	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public int getPicnum() {
		return picnum;
	}


	public void setPicnum(int picnum) {
		this.picnum = picnum;
	}


	public Board getBoard() {
		return board;
	}


	public void setBoard(Board board) {
		this.board = board;
		this.bname = board.getBname();
		this.info = board.getInfo();
		this.username = board.getUser().getUsername();
	}


	public BoardStat getBoardStat() {
		return boardStat;
	}

	public void setBoardStat(BoardStat boardStat) {
		this.boardStat = boardStat;
		this.followerCount = boardStat.getFollowerCount();
		this.pinCount = boardStat.getPinCount();
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PinService getService() {
		return service;
	}

	public void setBoardList(ArrayList<Board> boardList) {
		this.boardList = boardList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
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

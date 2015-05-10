package com.service.impl;

import java.util.ArrayList;
import java.util.Date;

import com.bean.Board;
import com.bean.Comment;
import com.bean.Follow;
import com.bean.Likes;
import com.bean.Picture;
import com.bean.Pin;
import com.bean.User;
import com.dao.PinDAO;
import com.dao.UserDAO;
import com.service.PinService;
import com.util.BoardStat;
import com.util.ErrorType;
import com.util.PinStat;
import com.util.UserStat;

public class PinServiceImpl implements PinService {
	
	private PinDAO pinDAO;	
	
	private UserDAO userDAO;	



	public PinDAO getPinDAO() {
		return pinDAO;
	}

	public void setPinDAO(PinDAO pinDAO) {
		this.pinDAO = pinDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public int addBoard(String username, String bname, String info){
     	Board board = new Board();
     	User user = this.userDAO.findUserByUsername(username);
     	if(user == null){
     		return ErrorType.USER_NOT_EXIST.compareTo(ErrorType.NO_ERROR);
     	}
     	board.setUser(user);
		board.setBname(bname);
		board.setInfo(info);
		board.setTime(new Date());
		Board board1 = this.pinDAO.findBoardByUsernameBname(username, bname);
		if (board1!=null) {
			return ErrorType.BOARD_EXISTED.compareTo(ErrorType.NO_ERROR);
		}
		try {
			this.pinDAO.addBoard(board);
		} catch(Exception e) {
			e.printStackTrace();
			return ErrorType.BNAME_EXISTED.compareTo(ErrorType.NO_ERROR);
		}
		return board.getBid();
	}
	
	@Override
	public ErrorType deleteBoard(int bid){
		Board board = pinDAO.findBoardByBid(bid);
		if(board == null)
			return ErrorType.BOARD_NOT_EXISTED;
		try{
			this.pinDAO.deleteBoard(board);
		} catch(Exception e){
			e.printStackTrace();
			return ErrorType.DELETE_ERROR;
		}
		return ErrorType.NO_ERROR;		
	}
	
	@Override
	public ErrorType updateBoard(int bid, String bname, String info){
		Board board = pinDAO.findBoardByBid(bid);
		User user = board.getUser();
		Board board1 = pinDAO.findBoardByUsernameBname(user.getUsername(), bname);
		if(board1 != null && board1.getBid() != bid)
			return ErrorType.BOARD_EXISTED;
		board.setBname(bname);
		board.setInfo(info);
		try{
			pinDAO.updateBoard(board);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.UPDATE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public Board findBoardByBid(int bid){
		Board board = pinDAO.findBoardByBid(bid);
		return board;
	}
	
	@Override
	public ArrayList<Board> findBoardByUsername(String username){
		ArrayList<Board> boards = pinDAO.findBoardByUsername(username);
		return boards;
	}
	
	@Override
	public Board findBoardByUsernameBname(String username, String bname){
		Board board = pinDAO.findBoardByUsernameBname(username, bname);
		return board;
	}
	
	@Override
	public ArrayList<Board> findBoardByFollow(String username){
		ArrayList<Board> boards = pinDAO.findBoardByFollow(username);
		return boards;
	}
	
	@Override
	public ArrayList<Board> findBoardByStream(String info){
		ArrayList<Board> boards = pinDAO.findBoardByStream(info);
		return boards;
	}
	
	@Override
	public ArrayList<Board> findBoardByInfo(String info){
		ArrayList<Board> boards = pinDAO.findBoardByInfo(info);
		return boards;
	}
	
	@Override
	public ArrayList<Board> findBoardByKeyword(String keyword){
		ArrayList<Board> boards = pinDAO.findBoardByKeyword(keyword);
		return boards;
	}
	
	@Override
    public ArrayList<Board> findBoardByPicnum(int picnum){
		ArrayList<Board> boards = pinDAO.findBoardByPicnum(picnum);
		return boards;
	}
	
	/*
	@Override
	public ErrorType addPicture(String url, String sourceUrl){
		Picture picture = new Picture();
		picture.setUrl(url);
		picture.setSourceUrl(sourceUrl);
		try{
			pinDAO.addPicture(picture);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.ADD_PICTURE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	*/
	
	@Override
	public int addPicture(String url, String sourceUrl){
		Picture picture = new Picture();
		picture.setUrl(url);
		picture.setSourceUrl(sourceUrl);
		try{
			pinDAO.addPicture(picture);
		}catch(Exception e){
			return ErrorType.ADD_PICTURE_ERROR.compareTo(ErrorType.NO_ERROR);
		}
		return picture.getPicnum();
	}
	
	@Override
	public ErrorType deletePicture(int picnum){
		Picture picture = pinDAO.findPictureByPicnum(picnum);
		if (picture == null)
			return ErrorType.PICTURE_NOT_EXISTED;
		try{
			pinDAO.deletePicture(picture);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.DELETE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public Picture findPictureByPicnum(int picnum){
		Picture picture = pinDAO.findPictureByPicnum(picnum);
		return picture;
	}
	
	@Override
	public ArrayList<Picture> findPictureByUsername(String username){
		ArrayList<Picture> pictures = pinDAO.findPictureByUsername(username);
		return pictures;
	}
	
	@Override
	public ArrayList<Picture> findPictureByBid(int bid){
		ArrayList<Picture> pictures = pinDAO.findPictureByBid(bid);
		return pictures;
	}
	
	@Override
	public ArrayList<Picture> findPictureByLikes(String username){
		ArrayList<Picture> pictures = pinDAO.findPictureByLikes(username);
		return pictures;		
	}
	
	@Override
	public int addPin(int bid, int picnum, String discription, int repin){
		Pin pin1 = pinDAO.findPinByBidPicnum(bid, picnum);
//		if(pin1 != null){
//			//return ErrorType.PIN_EXISTED.compareTo(ErrorType.NO_ERROR);
//		}
//		else{
		    Pin pin = new Pin();
		    Board board = pinDAO.findBoardByBid(bid);
		    if(board == null)
		    	return ErrorType.BOARD_NOT_EXISTED.compareTo(ErrorType.NO_ERROR);
		    Picture picture = pinDAO.findPictureByPicnum(picnum);
		    if(picture == null)
		    	return ErrorType.PICTURE_NOT_EXISTED.compareTo(ErrorType.NO_ERROR);
		    pin.setBoard(board);
		    pin.setPicture(picture);
		    pin.setNote(discription);
		    pin.setRepin(repin);
		    pin.setTime(new Date());
		    pinDAO.addPin(pin);
		    return pin.getPinid();
	//	}		
	}
	
	@Override
	public ErrorType deletePin(int pinid){
		Pin pin = pinDAO.findPinByPinid(pinid);
		if(pin == null) {
			return ErrorType.PIN_NOT_EXISTED;
		}
		if (pin.getRepin()<0) {
			try {
				pinDAO.deletePicture(pin.getPicture());
				return ErrorType.NO_ERROR;
			} catch(Exception e) {
				e.printStackTrace();
				return ErrorType.DELETE_PICTURE_ERROR;
			}
		}
		try{
			pinDAO.deletePin(pin);			
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.DELETE_ERROR;
		}
				
		return ErrorType.NO_ERROR;
	}
	
	
	@Override
	public ErrorType updatePin(int pinid, int bid, String note){
		System.out.println(">>>>>>>>>Enter updatePin(" + pinid + ", " + bid + ", " + note);
		int picnum = pinDAO.findPictureByPinid(pinid).getPicnum();
//		Pin pin1 = pinDAO.findPinByBidPicnum(bid, picnum);
//		if(pin1 != null)
//			return ErrorType.PIN_EXISTED;
		Pin pin = pinDAO.findPinByPinid(pinid);
		if(pin == null)
			return ErrorType.PIN_NOT_EXISTED;
		Board board = pinDAO.findBoardByBid(bid);
		pin.setBoard(board);
		pin.setNote(note);
		System.out.println(">>>>>>>>new pin: pinid = " + pin.getPinid() + 
				"\tbid = " + pin.getBoard().getBid() + "\tnote = " + pin.getNote());
		//System.exit(0);
		try{
			pinDAO.updatePin(pin);
		}catch(Exception e){
			//e.printStackTrace();
			return ErrorType.UPDATE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public Pin findPinByPinid(int pinid){
		Pin pin = pinDAO.findPinByPinid(pinid);
		return pin;
	}
	
	@Override
	public ArrayList<Pin> findPinByBid(int bid){
		ArrayList<Pin> pins = pinDAO.findPinByBid(bid);
		return pins;
	}
	
	@Override
	public ArrayList<Pin> takePin(int pinid){
		ArrayList<Pin> pins = pinDAO.takePin(pinid);
		return pins;
	}
	@Override
	public int addFollow(String username, int bid, String stream){
		Follow follow1 = pinDAO.findFollowByUsernameBid(username, bid);
		if(follow1 != null)
			return ErrorType.FOLLOW_EXISTED.compareTo(ErrorType.NO_ERROR);
		User user = userDAO.findUserByUsername(username);
		if(user == null)
			return ErrorType.USER_NOT_EXIST.compareTo(ErrorType.NO_ERROR);
		Board board = pinDAO.findBoardByBid(bid);
		if(board == null)
			return ErrorType.BOARD_NOT_EXISTED.compareTo(ErrorType.NO_ERROR);
		Follow follow = new Follow();
		follow.setUser(user);
		follow.setBoard(board);
		follow.setStream(stream);
		follow.setTime(new Date());
		try{
			pinDAO.addFollow(follow);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.ADD_FOLLOW_ERROR.compareTo(ErrorType.NO_ERROR);
		}
		return follow.getIdfollow();	
	}
	
	@Override
	public ErrorType deleteFollow(int idfollow){
		Follow follow = pinDAO.findFollowByIdfollow(idfollow);
		if(follow == null)
			return ErrorType.FOLLOW_NOT_EXISTED;
		try{
			pinDAO.deleteFollow(follow);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.DELETE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public ArrayList<User> findUserByFollow(int bid){
		ArrayList<User> users = pinDAO.findUserByFollow(bid);
		return users;
	}
	
	@Override
	public int addComment(String username, int pinid, String content){
		User user = userDAO.findUserByUsername(username);
		if(user == null)
			return ErrorType.USER_NOT_EXIST.compareTo(ErrorType.NO_ERROR);
		Pin pin = pinDAO.findPinByPinid(pinid);
		if(pin == null)
			return ErrorType.PIN_NOT_EXISTED.compareTo(ErrorType.NO_ERROR);
		Comment comment1 = new Comment();
		comment1.setUser(user);
		comment1.setPin(pin);
		comment1.setContent(content);
		comment1.setTime(new Date());
		try{
			pinDAO.addComment(comment1);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.ADD_COMMENT_ERROR.compareTo(ErrorType.NO_ERROR);
		}
		return comment1.getCid();
	}
	
	@Override
	public ErrorType deleteComment(int cid){
		Comment comment = pinDAO.findCommentByCid(cid);
		if(comment == null)
			return ErrorType.COMMENT_NOT_EXISTED;
		try{
			pinDAO.deleteComment(comment);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.DELETE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public ArrayList<Comment> findCommentByUsername(String username){
		ArrayList<Comment> comments = pinDAO.findCommentByUsername(username);
		return comments;
	}
	
	@Override
	public ArrayList<Comment> findCommentByPinid(int pinid){
		ArrayList<Comment> comments = pinDAO.findCommentByPinid(pinid);
		return comments;
	}
	
	@Override
	public int addLikes(String username, int picnum){
		Likes likes1 = pinDAO.findLikesByUsernamePicnum(username, picnum);
		if(likes1 != null)
			return ErrorType.LIKES_EXISTED.compareTo(ErrorType.NO_ERROR);
		User user = userDAO.findUserByUsername(username);
		if(user == null)
			return ErrorType.USER_NOT_EXIST.compareTo(ErrorType.NO_ERROR);
		Picture picture = pinDAO.findPictureByPicnum(picnum);
		if(picture == null)
			return ErrorType.PICTURE_NOT_EXISTED.compareTo(ErrorType.NO_ERROR);
		Likes likes = new Likes();
		likes.setUser(user);
		likes.setPicture(picture);
		likes.setTime(new Date());
		try{
			pinDAO.addLikes(likes);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.ADD_LIKES_ERROR.compareTo(ErrorType.NO_ERROR);
		}
		return likes.getIdlikes();
	}
	
	@Override
	public ErrorType deleteLikes(int idlikes){
		Likes likes = pinDAO.findLikesByIdlikes(idlikes);
		if(likes == null)
			return ErrorType.LIKES_NOT_EXISTED;
		try{
			pinDAO.deleteLikes(likes);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.DELETE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public ErrorType deleteLikesByUsernamePicnum(String username, int picnum){
		Likes likes = pinDAO.findLikesByUsernamePicnum(username, picnum);
		if(likes == null)
			return ErrorType.LIKES_NOT_EXISTED;
		try{
			pinDAO.deleteLikes(likes);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.DELETE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}
	
	@Override
	public ArrayList<Likes> findLikesByUsername(String username){
		ArrayList<Likes> likes = pinDAO.findLikesByUsername(username);
		return likes;
	}
	
	@Override
	public ArrayList<Likes> findLikesByPicnum(int picnum){
		ArrayList<Likes> likes = pinDAO.findLikesByPicnum(picnum);
		return likes;
	}

	/*
	@Override
	public int[] userBasicStatistic(String username){
		int[] i = {0,0,0,0};
		ArrayList<Board> boards = pinDAO.findBoardByUsername(username);
		if(boards == null)
			i[0] = 0;
		else
		    i[0] = boards.size();
		ArrayList<Pin> pins = pinDAO.findPinByUsername(username);
		if(pins == null)
			i[1] = 0;
		else
			i[1] = pins.size();
		ArrayList<Likes> likes = pinDAO.findLikesByUsername(username);
		if(likes == null)
			i[2] = 0;
		else
			i[2] = likes.size();
		ArrayList<User> friends = userDAO.findFriendsByUsername(username);
		if(friends == null)
			i[3] = 0;
		else
			i[3] = friends.size();
		return i;
	}
	*/
	
//	@Override
//	public int[] userBasicStatistic(String username){
//		int[] i = {0,0,0,0};
//		i[0] = pinDAO.countBoardByUsername(username);
//		i[1] = pinDAO.countPinByUsername(username);
//		i[2] = pinDAO.countLikesByUsername(username);
//		i[3] = userDAO.countFriendByUsername(username);
//		return i;
//	}
	
	@Override
	public UserStat userBasicStatistic(String username) {	
		int bc = pinDAO.countBoardByUsername(username);
		int pc = pinDAO.countPinByUsername(username);
		int lc = pinDAO.countLikesByUsername(username);
		int frc = userDAO.countFriendByUsername(username);
		int foc = pinDAO.countFollowingByUsername(username);
		return new UserStat(bc, pc, lc, frc, foc);
	}
	
//	@Override
//	public int[] boardBasicStatistic(int bid){
//		int[] i = {0,0};
//		i[0] = pinDAO.countPinByBid(bid);
//		i[1] = pinDAO.countFollowByBid(bid);
//		return i;
//	}
	
	@Override
	public BoardStat boardBasicStatistic(int bid){
		return new BoardStat(bid, pinDAO.countPinByBid(bid), pinDAO.countFollowByBid(bid));		
	}
	
	@Override
	public PinStat pinBasicStatistic(String username, int pinid){
		Pin pin = pinDAO.findPinByPinid(pinid);
		Likes likes = pinDAO.findLikesByUsernamePicnum(username, pin.getPicture().getPicnum());
		String liked = (likes==null) ? "Unlike":"Like";
		return new PinStat(pinid,
				pinDAO.countRepinByPinid(pinid),
				pinDAO.countLikesByPinid(pinid),
				pinDAO.countCommentByPinid(pinid),
				liked
				);
	}

	@Override
	public ArrayList<PinStat> pinStatListByPinList(String username, ArrayList<Pin> pinList) {
		ArrayList<PinStat> stats = new ArrayList<PinStat>();
		int len = pinList.size();
		for (int i = 0; i < len; i++) {
			stats.add(pinBasicStatistic(username, pinList.get(i).getPinid()));
		}
		return stats;
	}
	
	@Override
	public ArrayList<User> findUserByLikes(int picnum){
		ArrayList<User> users = pinDAO.findUserByLikes(picnum);
		return users;
	}
	
	@Override
	public ArrayList<String> findStreamByUsername(String username){
		ArrayList<String> streams = pinDAO.findStreamByUsername(username);
		return streams;
	}
	
	@Override
	public ErrorType updateFollow(String username, int bid, String stream){
		Follow follow = pinDAO.findFollowByUsernameBid(username, bid);
		if(follow==null)
			return ErrorType.FOLLOW_NOT_EXISTED;
		follow.setStream(stream);
		try{
			pinDAO.updateFollow(follow);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.UPDATE_ERROR;
		}
		return ErrorType.NO_ERROR;		
	}
	
	@Override
	public ErrorType changeFollowStream(String username, String oldstream, String stream){
		try{
			pinDAO.changeFollowStream(username, oldstream, stream);
		}catch(Exception e){
			e.printStackTrace();
			return ErrorType.UPDATE_ERROR;
		}
		return ErrorType.NO_ERROR;
	}

	@Override
	public Follow findFollowByUsernameBid(String username, int bid){
		Follow follow = pinDAO.findFollowByUsernameBid(username, bid);
		return follow;
	}
	
	@Override
	public ArrayList<Pin> takePinByBidOrder(){
		ArrayList<Pin> pins = pinDAO.takePinByBidOrder();
		return pins;
	}

	@Override
	public ArrayList<Pin> findPinByTag(String tag){
		ArrayList<Pin> pinlist = pinDAO.findPinByTag(tag);
		return pinlist;
	}
	
}
    

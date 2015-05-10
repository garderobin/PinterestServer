package com.dao;
import java.util.ArrayList;

import com.bean.*;

public interface PinDAO {
	
	public void addBoard(Board board);
	public void deleteBoard(Board board);
	public void updateBoard(Board board);
	public Board findBoardByBid(int bid);
	public ArrayList<Board> findBoardByUsername(String username);
	public Board findBoardByUsernameBname(String username, String bname);
	public ArrayList<Board> findBoardByFollow(String username);
	public ArrayList<Board> findBoardByStream(String stream);
	public ArrayList<Board> findBoardByKeyword(String keyword); 
	public ArrayList<Board> findBoardByPicnum(int picnum);
	public void addPicture(Picture picture);
	public void deletePicture(Picture picture);
	public void updatePicture(Picture picture);
	public Picture findPictureByPicnum(int picnum);
	public Picture findPictureByPinid(int pinid);
	public ArrayList<Picture> findPictureByUsername(String username);
	public ArrayList<Picture> findPictureByBid(int bid);
	public ArrayList<Picture> findPictureByLikes(String username);	
	public void addPin(Pin pin);
	public void deletePin(Pin pin);
	public void updatePin(Pin pin);
	public Pin findPinByPinid(int pinid);
	public Pin findPinByBidPicnum(int bid, int picnum);
	public ArrayList<Pin> findPinByBid(int bid);
	public ArrayList<Pin> takePin(int pinid);
	public void addFollow(Follow follow);
	public void deleteFollow(Follow follow);
	public void updateFollow(Follow follow);
	public Follow findFollowByIdfollow(int idfollow);
	public Follow findFollowByUsernameBid(String username, int bid);
	public ArrayList<User> findUserByFollow(int bid);
	public void addComment(Comment comment);
	public void deleteComment(Comment comment);
	public void updateComment(Comment comment);
	public Comment findCommentByCid(int cid);
	public ArrayList<Comment> findCommentByUsername(String username);
	public ArrayList<Comment> findCommentByPinid(int pinid);	
	public void addLikes(Likes likes);
	public void deleteLikes(Likes likes);
	public Likes findLikesByIdlikes(int idlikes);
	public Likes findLikesByUsernamePicnum(String username, int picnum);
	public ArrayList<Likes> findLikesByUsername(String username);
	public ArrayList<Likes> findLikesByPicnum(int picnum);
	
	public ArrayList<Pin> findPinByUsername(String username);
	
	public int countBoardByUsername(String username);
	public int countPinByUsername(String username);
	public int countLikesByUsername(String username);
	
	public int countPinByBid(int bid);
	public int countFollowByBid(int bid);
	
	public int countRepinByPinid(int pinid);
	public int countLikesByPinid(int pinid);
	public int countCommentByPinid(int pinid);
	public int countFollowingByUsername(String username);
	public ArrayList<User> findUserByLikes(int picnum);
	public ArrayList<String> findStreamByUsername(String username);
	public void changeFollowStream(String username, String oldstream,
			String stream);
	public ArrayList<Board> findBoardByInfo(String info);
	public ArrayList<Pin> takePinByBidOrder();
	public ArrayList<Pin> findPinByTag(String tag);
}

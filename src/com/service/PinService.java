package com.service;

import java.util.ArrayList;

import com.bean.*;
import com.util.BoardStat;
import com.util.ErrorType;
import com.util.PinStat;
import com.util.UserStat;
public interface PinService {
	
	/* Board */
    //public ErrorType addBoard(String username, String bname, String stream);
	public int addBoard(String username, String bname, String steam);
    public ErrorType deleteBoard(int bid);
    public ErrorType updateBoard(int bid, String bname, String stream);
    public Board findBoardByBid(int bid);
    public ArrayList<Board> findBoardByUsername(String username);
    public Board findBoardByUsernameBname(String username, String bname);    
    public ArrayList<Board> findBoardByStream(String stream);
    public ArrayList<Board> findBoardByInfo(String info);
    public ArrayList<Board> findBoardByKeyword(String keyword);
    public ArrayList<Board> findBoardByPicnum(int picnum);
    
    /* Picture */
    //public ErrorType addPicture(String url, String sourceUrl);	
    public int addPicture(String url, String sourceUrl);
    public ErrorType deletePicture(int picnum);
    public Picture findPictureByPicnum(int picnum);
    public ArrayList<Picture> findPictureByUsername(String username);
    public ArrayList<Picture> findPictureByBid(int bid);
    public ArrayList<Picture> findPictureByLikes(String username);
    
    /* Pin */
    public int addPin(int bid, int picnum, String discription, int repin);
    public ErrorType deletePin(int pinid);
    public ErrorType updatePin(int pinid, int bid, String discription);
    public Pin findPinByPinid(int pinid);
    public ArrayList<Pin> findPinByBid(int bid);
    public ArrayList<Pin> takePin(int pinid);
    
    /* Follow */
    public int addFollow(String username, int bid, String stream);
    public ErrorType deleteFollow(int idfollow);
    public ArrayList<User> findUserByFollow(int bid);
    public ArrayList<Board> findBoardByFollow(String username);
    
    /* Comment */
    public int addComment(String username, int pinid, String content);
    public ErrorType deleteComment(int cid);
    public ArrayList<Comment> findCommentByUsername(String username);
    public ArrayList<Comment> findCommentByPinid(int pinid);
    
    /* Likes */
    public int addLikes(String username, int picnum);
    public ErrorType deleteLikes(int idlikes);
    public ArrayList<Likes> findLikesByUsername(String username);
    public ArrayList<Likes> findLikesByPicnum(int picnum);
    
    /* Statistic */
    /**
     * @param username
     * @return 	int[0]: num of boards
     * 		 	int[1]: num of pins
     * 			int[2]: num of likes
     * 			int[3]: num of friends
     */
    //public int[] userBasicStatistic(String username);
    public UserStat userBasicStatistic(String username);
    /**
     * 
     * @param bid
     * @return	int[0]: num of pins
     * 			int[0]: num of followers
     */
    //public int[] boardBasicStatistic(int bid);
    public BoardStat boardBasicStatistic(int bid);
    /**
     * 
     * @param pinid
     * @return	int[0]: num of repins
     * 			int[1]: num of likes
     *          int[2]: num of comments
     */
    //public int[] pinBasicStatistic(int pinid);    
    //public PinStat pinBasicStatistic(int pinid);
    
    //public ArrayList<PinStat> pinStatListByPinList(ArrayList<Pin> pinList);
	public ErrorType deleteLikesByUsernamePicnum(String username, int picnum);
	public PinStat pinBasicStatistic(String username, int pinid);
	public ArrayList<PinStat> pinStatListByPinList(String username,
			ArrayList<Pin> pinList);
	
	public ArrayList<User> findUserByLikes(int picnum);
	public ArrayList<String> findStreamByUsername(String username);
	public ErrorType updateFollow(String username, int bid, String stream);
	public Follow findFollowByUsernameBid(String username, int bid);
	public ErrorType changeFollowStream(String username, String oldstream,
			String stream);
	public ArrayList<Pin> takePinByBidOrder();
	public ArrayList<Pin> findPinByTag(String tag);
	
}

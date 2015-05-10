package test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.bean.User;
import com.bean.Board;
import com.bean.Picture;
import com.bean.Likes;
import com.bean.Pin;
import com.bean.Follow;
import com.bean.Comment;
import com.dao.PinDAO;
import com.dao.UserDAO;

public class PinDAOImplTest extends BaseSpringContextCommon {
	
	@Autowired  
    @Qualifier("pinDAO")  
    private PinDAO pinDAO;	
	@Autowired
	@Qualifier("userDAO")  
    private UserDAO userDAO;

	/*
	@Test
	public void testAddBoard() {
		Date time = new Date();
		String username = "dongtao";
		User user = userDAO.findUserByUsername(username);
		String bname = "pig";
		Board board = new Board();
		board.setUser(user);
		board.setBname(bname);
		board.setTime(time);
        pinDAO.addBoard(board);	
	}
	
	
	@Test
	public void testDeleteBoard() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");		
		Date time = format.parse("2015-04-23 14:54:19");
		String username = "dongtao";
		User user = userDAO.findUserByUsername(username);
		String bname = "pig";
		Board board = new Board();
		board.setBid(4);
		board.setUser(user);
		board.setBname(bname);
		board.setTime(time);
        pinDAO.deleteBoard(board);	
	}
	
	
	@Test
	public void testupdateBoard() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");		
		Date time = format.parse("2015-04-23 14:54:19");
		String username = "dongtao";
		User user = userDAO.findUserByUsername(username);
		String bname = "cat";
		Board board = new Board();
		board.setBid(5);
		board.setUser(user);
		board.setBname(bname);
		board.setTime(time);
        pinDAO.updateBoard(board);	
	}
	
	
	@Test
	public void testFindBoardByBid() {
		int bid = 3;
        Board board = pinDAO.findBoardByBid(bid);	
        assertEquals("tousername", board.getUser().getUsername());
	}
	
	
	@Test 
	public void testFindBoardByUsername(){
		String username = "dongtao";
		Board board = pinDAO.findBoardByUsername(username).get(3);
		assertEquals("pig", board.getBname());
	}
	
	@Test
	public void testFindBoardByUsernameBname(){
		String username = "dongtao";
		String bname = "cat";
		Board board = pinDAO.findBoardByUsernameBname(username, bname);
		assertEquals("cat",board.getBname());
	}

	
	@Test
	public void testFindBoardByFollow(){
		String username = "Tom";
		ArrayList<Board> boards = pinDAO.findBoardByFollow(username);
		if(boards.get(0)!=null){
			Board board = boards.get(0);
		    assertEquals(1,board.getBid());
		}
		else
			assertEquals(null, boards.get(0));
	}
	
	@Test 
	public void testAddPicture(){
		String url = "url1";
		String sourceUrl = "sourceUrl1";
		Picture picture = new Picture();
		picture.setUrl(url);
		picture.setSourceUrl(sourceUrl);
        pinDAO.addPicture(picture);
	}
	*/
	
	@Test 
	public void testDeletePicture(){
		int picnum = 3;
		Picture picture = pinDAO.findPictureByPicnum(picnum);
        pinDAO.deletePicture(picture);
	}
	
	/*
	@Test 
	public void testFindPictureByPicnum(){
		int picnum = 1;
		Picture picture = pinDAO.findPictureByPicnum(picnum);
		assertEquals("presentURL",picture.getUrl());
	}
	
	
	@Test
	public void testFindPictureByUsername(){
		String username = "dongtao";
		ArrayList<Picture> pictures = pinDAO.findPictureByUsername(username);
		Picture picture = pictures.get(1);
		assertEquals(3, picture.getPicnum());
	}
	
	
	@Test
	public void testFindPictureByBid(){
		int bid = 2;
		ArrayList<Picture> pictures = pinDAO.findPictureByBid(bid);
		Picture picture = pictures.get(0);
		assertEquals(3, picture.getPicnum());
	}
	
	
	@Test
	public void testFindPictureByLikes(){
		String username = "dongtao";
		ArrayList<Picture> pictures = pinDAO.findPictureByLikes(username);
		Picture picture = pictures.get(0);
		assertEquals("presentURL", picture.getUrl());		
	}
	
	
	@Test
	public void testAddPin(){
		int bid = 2;
		Board board = pinDAO.findBoardByBid(bid);
		int picnum = 3;
		Picture picture = pinDAO.findPictureByPicnum(picnum);
		String note = "defdsegg";
		Date time = new Date();
		int repin = 0;
        Pin pin = new Pin();
        pin.setBoard(board);
        pin.setPicture(picture);
        pin.setNote(note);
        pin.setTime(time);
        pin.setRepin(repin);
        pinDAO.addPin(pin);
	}
	
	
	@Test
	public void testDeletePin(){
		int pinid = 8;
		int bid = 2;
		Board board = pinDAO.findBoardByBid(bid);
		int picnum = 3;
		Picture picture = pinDAO.findPictureByPicnum(picnum);
		String note = "defdsegg";
		Date time = new Date();
		int repin = 0;
        
        Pin pin = new Pin();
        pin.setPinid(pinid);
        pin.setBoard(board);
        pin.setPicture(picture);
        pin.setNote(note);
        pin.setTime(time);
        pin.setRepin(repin);
        
        pinDAO.deletePin(pin);
	}
	
	
	@Test 
	public void testFindPinByPinid(){
		int pinid = 3;
		Pin pin = pinDAO.findPinByPinid(pinid);
		assertEquals("addfer", pin.getNote());
	}
	
	
	
	@Test
	public void testAddFollow(){
		String username = "dongtao";
		User user = userDAO.findUserByUsername(username);
		int bid = 6;
		Board board = pinDAO.findBoardByBid(bid);
		String stream = "aabbcc";
		Date time = new Date();
		Follow follow = new Follow();
		follow.setUser(user);
		follow.setBoard(board);
		follow.setStream(stream);
		follow.setTime(time);
		pinDAO.addFollow(follow);
	}
	
	
	@Test
	public void deleteAddFollow(){
		int idfollow = 2;
		String username = "dongtao";
		User user = userDAO.findUserByUsername(username);
		int bid = 6;
		Board board = pinDAO.findBoardByBid(bid);
		String stream = "aabbcc";
		Date time = new Date();
		Follow follow = new Follow();
		follow.setIdfollow(idfollow);
		follow.setUser(user);
		follow.setBoard(board);
		follow.setStream(stream);
		follow.setTime(time);
		pinDAO.deleteFollow(follow);
	}
	
	
	@Test
	public void testFindUserByFollow(){
		int bid = 1;
		ArrayList<User> users = pinDAO.findUserByFollow(bid);
		User user = users.get(0);
		assertEquals("Tom", user.getUsername());
	}
	
	
	@Test
	public void testFindFollowByUsername(){
		String username = "Tom";
		ArrayList<Follow> follows = pinDAO.findFollowByUsername(username);
		Follow follow = follows.get(0);
		assertEquals("Animal", follow.getStream());
	}
	
	@Test
	public void testAddComment(){
		String username = "dongtao";
		User user = userDAO.findUserByUsername(username);
		int pinid = 3;
		Pin pin = pinDAO.findPinByPinid(pinid);
		String comment1 = "aavvee";
		Date time = new Date();
		Comment comment = new Comment();
		comment.setUser(user);
		comment.setPin(pin);
		comment.setComment(comment1);
		comment.setTime(time);
		pinDAO.addComment(comment);
	}
	
	@Test
	public void testDeleteComment(){
		int cid = 1;
		String username = "dongtao";
		User user = userDAO.findUserByUsername(username);
		int pinid = 3;
		Pin pin = pinDAO.findPinByPinid(pinid);
		String comment1 = "aavvee";
		Date time = new Date();
		Comment comment = new Comment();
		comment.setCid(cid);
		comment.setUser(user);
		comment.setPin(pin);
		comment.setComment(comment1);
		comment.setTime(time);
		pinDAO.deleteComment(comment);
	}
	
	
	@Test 
	public void testFindCommentByUsername(){
		String username = "dongtao";
		ArrayList<Comment> comments = pinDAO.findCommentByUsername(username);
		Comment comment = comments.get(0);
		assertEquals("aavvee", comment.getComment());
	}
	
	
	@Test
	public void testFindCommentByPinid(){
		int pinid = 3;
		ArrayList<Comment> comments = pinDAO.findCommentByPinid(pinid);
		Comment comment = comments.get(0);
		assertEquals("dongtao", comment.getUser().getUsername());
	}
	
	
	
	@Test
	public void testAddLikes(){
		Date time = new Date();
		String username = "dongtao";
		User user = userDAO.findUserByUsername(username);
		int picnum = 1;
		Picture picture = pinDAO.findPictureByPicnum(picnum);
		Likes likes = new Likes();
		likes.setUser(user);
		likes.setPicture(picture);
		likes.setTime(time);
		pinDAO.addLikes(likes);
	}
	
	
	@Test
	public void testDeleteLikes(){
		Date time = new Date();
		String username = "dongtao";
		User user = userDAO.findUserByUsername(username);
		int picnum = 1;
		int idlikes = 1;
		Picture picture = pinDAO.findPictureByPicnum(picnum);
		Likes likes = new Likes();
		likes.setUser(user);
		likes.setPicture(picture);
		likes.setTime(time);
		likes.setIdlikes(idlikes);
		pinDAO.deleteLikes(likes);		
	}
	
	@Test public void testFindLikesByUsername(){
		String username = "dongtao";
		Likes likes = (Likes) pinDAO.findLikesByUsername(username).get(0);
		assertEquals(1, likes.getPicture().getPicnum());
	}

	@Test public void testFindLikesByPicnum(){
		int picnum = 1;
		Likes likes = (Likes) pinDAO.findLikesByPicnum(picnum).get(0);
		assertEquals("dongtao", likes.getUser().getUsername());
	}
    */
}
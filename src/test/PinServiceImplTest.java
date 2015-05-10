package test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.util.ErrorType;

import com.service.UserService;
import com.service.PinService;

import com.bean.*;
import com.dao.PinDAO;
import com.dao.UserDAO;


public class PinServiceImplTest extends BaseSpringContextCommon{
	
	@Autowired  
    @Qualifier("pinDAO")  
    private PinDAO pinDAO;	
	@Autowired
	@Qualifier("userDAO")  
    private UserDAO userDAO;
	
	@Autowired  
    @Qualifier("userService")  
    private UserService userService;
	
	@Autowired  
    @Qualifier("pinService")  
    private PinService pinService;
	
	
//	@Test
//	public void testAddBoard(){
//		String username = "dongtao";
//		String bname = "birds";
//		String stream = "pets";
//		ErrorType errortype = pinService.addBoard(username, bname,stream);
//		assertEquals(ErrorType.NO_ERROR, errortype);
//	}
	/*
	@Test 
	public void testDeleteBoard(){
		int bid = 5;
		ErrorType errortype = pinService.deleteBoard(bid);
		assertEquals(ErrorType.NO_ERROR, errortype);
	}
	
	@Test
	public void testUpdateBoard(){
		int bid = 1;
		String bname = "flower";
		ErrorType error = pinService.updateBoard(bid, bname);
		assertEquals(ErrorType.NO_ERROR, error);
	}
	
	@Test
	public void testFindBoardByUsername(){
		String username = "dongtao";
		ArrayList<Board> boards = pinService.findBoardByUsername(username);
		assertEquals(4,boards.size());
	}
	
	
	@Test
	public void testFindBoardByUsernameBname(){
		String username = "dongtao";
		String bname = "dog";
		Board board = pinService.findBoardByUsernameBname(username, bname);
		if(board == null)
		    assertEquals(null, board);
		else 
			assertEquals("dog", board.getBname());
	}
	
	
	@Test
	public void testFindBoardByFollow(){
		String username = "zdre";
		ArrayList<Board> boards = pinService.findBoardByFollow(username);
		if(boards == null)
			assertEquals(null, boards);
		else
			assertEquals(1, boards.size());
	}
	
	@Test
	public void testAddPicture(){
		String url = "12345";
		String sourceUrl = "abcde";
		ErrorType errortype = pinService.addPicture(url, sourceUrl);
		assertEquals(ErrorType.NO_ERROR, errortype);
	}
	
	@Test
	public void testDeletePicture(){
		int picnum = 3;
		ErrorType error = pinService.deletePicture(picnum);
		assertEquals(ErrorType.NO_ERROR, error);
		
	}

	@Test
	public void testFindPictureByPicnum(){
		int picnum = 10;
		Picture picture = pinService.findPictureByPicnum(picnum);
		if(picture == null)
			assertEquals(null, picture);
		else
			assertEquals("12345", picture.getUrl());
	}
	
	
	@Test
	public void testFindPictureByUsername(){
		String username = "Tom";
		ArrayList<Picture> pictures = pinService.findPictureByUsername(username);
		if(pictures == null)
			assertEquals(null, pictures);
		else
			assertEquals(3, pictures.size());
	}
	
	
	@Test
	public void testFindPictureByBid(){
		int bid = 2;
		ArrayList<Picture> pictures = pinService.findPictureByBid(bid);
		if(pictures == null)
			assertEquals(null, pictures);
		else
			assertEquals(3, pictures.size());
	}
	
	@Test
	public void testFindPictureByLikes(){
		String username = "Allen";
		ArrayList<Picture> pictures = pinService.findPictureByLikes(username);
		if(pictures == null)
			assertEquals(null, pictures);
		else
			assertEquals(2, pictures.size());
	}
	
	
	@Test
	public void testAddPin(){
		int bid = 2;
		int picnum = 5;
		String note = "112233";
		ErrorType error = pinService.addPin(bid, picnum, note);
		assertEquals(ErrorType.NO_ERROR, error);
	}
	
	
	@Test
	public void testDeletePin(){
		int pinid = 13;
		ErrorType error = pinService.deletePin(pinid);
		assertEquals(ErrorType.NO_ERROR, error);
	}
	*/
	
	@Test
	public void testUpdatePin(){
		int pinid = 14;
		int bid = 3;
		String note = "556677";
		ErrorType error = pinService.updatePin(pinid, bid, note);
		assertEquals(ErrorType.NO_ERROR, error);
	}
	
	/*
    @Test
	public void testFindPinByPinid(){
		int pinid = 14;
		Pin pin = pinService.findPinByPinid(pinid);
		if(pin == null)
			assertEquals(null, pin);
		else
			assertEquals("556677", pin.getNote());
	}
	
	/*
    @Test
	public void testAddFollow(){
		String username = "dongtao";
		int bid = 23;
		String stream = "223344";
		ErrorType error = pinService.addFollow(username, bid, stream);
		assertEquals(ErrorType.NO_ERROR, error);
	}
	
	
	@Test
	public void testDeleteFollow(){
		int idfollow = 14;
		ErrorType error = pinService.deleteFollow(idfollow);
		assertEquals(ErrorType.NO_ERROR, error);
	}
	
	
	@Test
	public void testFindUsersByFollow(){
		int bid = 6;
		ArrayList<User> users = pinService.findUserByFollow(bid);
		if(users == null)
			assertEquals(null, users);
		else
			assertEquals(2,users.size());
	}
	
	
	@Test
	public void testAddComment(){
		String username = "Allen";
		int pinid = 14;
		String comment = "334455";
		ErrorType error = pinService.addComment(username, pinid, comment);
		assertEquals(ErrorType.NO_ERROR, error);
	}
	
	
	@Test
	public void testDeleteComment(){
		int cid = 4;
		ErrorType error = pinService.deleteComment(cid);
		assertEquals(ErrorType.NO_ERROR, error);
	}
	
	
	@Test
	public void testFindCommentByUsername(){
		String username = "Barry";
		ArrayList<Comment> comments = pinService.findCommentByUsername(username);
		if(comments == null)
			assertEquals(null, comments);
		else
			assertEquals(2, comments.size());
	}
	
	
	@Test
	public void testFindCommentByPinid(){
		int pinid = 14;
		ArrayList<Comment> comments = pinService.findCommentByPinid(pinid);
		if(comments == null)
			assertEquals(null, comments);
		else
			assertEquals(3, comments.size());
	}
	
	
	@Test
	public void testAddLikes(){
		String username = "Alice";
		int picnum = 5;
		ErrorType error = pinService.addLikes(username, picnum);
		assertEquals(ErrorType.NO_ERROR, error);
	}
	
	
	@Test
	public void testDeleteLike(){
		int idlikes = 6;
		ErrorType error = pinService.deleteLikes(idlikes);
		assertEquals(ErrorType.NO_ERROR, error);
	}
	
	
	@Test
	public void testFindLikesByUsername(){
		String username = "Allen";
		ArrayList<Likes> likes = pinService.findLikesByUsername(username);
		if(likes == null)
			assertEquals(null, likes);
		else
			assertEquals(5, likes.get(0).getPicture().getPicnum());
	}
	*/
	
	@Test
	public void testFindLikesByPicnum(){
		int picnum = 5;
		ArrayList<Likes> likes = pinService.findLikesByPicnum(picnum);
		if(likes == null)
			assertEquals(null, likes);
		else
			assertEquals(2, likes.size());
	}
}
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

import com.bean.User;


public class UserServiceImplTest extends BaseSpringContextCommon{

	@Autowired  
    @Qualifier("userService")  
    private UserService userService;
	
	/*
	@Test
    public void testSignInUser(){
		String username = "ami";
		String password = "123456";
		String email = "lirong@hotmail.com";
		ErrorType errortype = userService.signInUser(username, password, email);
		assertEquals(ErrorType.NO_ERROR, errortype);
	}
	*/
	
	@Test
	public void testLoginUser(){
		String username = "zhaoxin";
		String password = "111314";
		ErrorType errortype = userService.loginUser(username, password);
		assertEquals(ErrorType.NO_ERROR, errortype);
	}
    
	/*
	@Test
	public void testFindFriendsByUsername(){
		String username = "myusername";
		ArrayList<User> friends = userService.findFriendsByUsername(username);
		ArrayList<String> exp = new ArrayList<String>(Arrays.asList("dongtao", "tousername"));
		boolean equals = true;
		for(User user: friends) {
			equals &= (exp.contains(user.getUsername()));
		}
		assertTrue(equals);
	}
	
	
	@Test 
	public void testAddFriend(){
		String username1 = "lirong";
		String username2 = "dongtao";
		ErrorType errortype = userService.addFriend(username1, username2);
		assertEquals(ErrorType.NO_ERROR, errortype);
	}
	
	
	@Test 
	public void testDeleteFriend(){
		String username1 = "dongtao";
		String username2 = "lirong";
		ErrorType errortype = userService.deleteFriend(username1, username2);
		assertEquals(ErrorType.NO_ERROR, errortype);
	}
	*/
}

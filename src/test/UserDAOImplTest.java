package test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.bean.Friend;
import com.bean.User;
import com.dao.UserDAO;

public class UserDAOImplTest extends BaseSpringContextCommon {
	
	@Autowired  
    @Qualifier("userDAO")  
    private UserDAO userDAO;	

	
	@Test
	public void testFindUserByUsername() {
		String username = "assa";
		User user = userDAO.findUserByUsername(username);
		if(user == null)
			assertEquals(null, user);
		else
		    assertEquals("dongtao@hotmail.com", user.getEmail());
	}
	

    /*
	@Test
	public void testSaveUser() {
		User user = new User();
    	user.setUsername("20140422");
        user.setEmail("myemail");      
        user.setPassword("myjassword"); 
        user.setTime(new Date());
        userDAO.saveUser(user);
	}

	@Test
	public void testUpdateUser() {		
		User user = userDAO.findUserByUsername("myusername");
		user.setEmail("20140422@gmail.com");
        userDAO.updateUser(user);
        assertEquals("20140422@gmail.com", userDAO.findUserByUsername("myusername").getEmail());
	}
	
	
	@Test
	public void testDeleteUser() {
		User user2 = userDAO.findUserByUsername("deleteAlone");
		userDAO.deleteUser(user2); //TODO test cascade deletion.
	}
	
	*/
	/*
	@Test
	public void testFindFriendsByUsername() {
		String username = "Allen";
		ArrayList<User> friends = userDAO.findFriendsByUsername(username);
		assertEquals(4, friends.size());
		User friend1 = friends.get(0);
		User friend2 = friends.get(1);
		User friend3 = friends.get(2);
		User friend4 = friends.get(3);
		assertEquals("Barry", friend1.getUsername());
		assertEquals("cousername",friend2.getUsername());
		assertEquals("lirong", friend3.getUsername());
		assertEquals("Tom ",friend4.getUsername());
	}
	
	 Another method!!!!!
	*/
	@Test
	public void testFindFriendsByUsername() {
		String username = "Allen";
		ArrayList<User> friends = userDAO.findFriendsByUsername(username);
		assertEquals(4, friends.size());
		ArrayList<String> exp = new ArrayList<String>(Arrays.asList("Barry", "Tom", "lirong", "cousername"));
		boolean equals = true;
		for(User user: friends) {
			equals &= (exp.contains(user.getUsername()));
		}
		assertTrue(equals);
	}
	
	
	/*
	@Test
	public void testFindFriendship() {
		Friend friend = userDAO.findFriendship("abcd", "test");
		assertNotEquals(null, friend);
		Friend friend2 = userDAO.findFriendship("none", "none");
		assertEquals(null, friend2);
	}

	
	@Test
	public void testAddFriend() throws ParseException {		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");		
		User user1 = new User("myusername", "myjassword", 
				"mynewemail@gmail.com", format.parse("2015-04-19 22:46:47"));
		User user2 = new User("tousername", "myjassword", 
				"myemail", format.parse("2015-04-21 03:46:42"));				
		Friend friendship = new Friend(user1, user2);
		userDAO.addFriend(friendship); // TODO try to add friend with user not exists.
	}
	
	
	@Test
	public void testDeleteFriend() throws ParseException {		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");		
		User user1 = new User("myusername", "myjassword", 
				"mynewemail@gmail.com", format.parse("2015-04-19 22:46:47"));
		User user2 = new User("tousername", "myjassword", 
				"myemail", format.parse("2015-04-21 03:46:42"));				
		Friend friendship = new Friend(user1, user2);
		userDAO.deleteFriend(friendship); // TODO try to delete friend with user not exists.
	}


	@Test
	public void testDeleteFriendByIdFriend() {
		int idfriend = 3;
		Friend friend = userDAO.findFriendByIdfriend(idfriend);		
		userDAO.deleteFriend(friend);
	}
	
	
	@Test
	public void testFindFriendByIdfriend() {
		int idfriend = 3;
		Friend friend = userDAO.findFriendByIdfriend(idfriend);		
		assertEquals("myusername", friend.getUser1().getUsername());
	}
	
	
	@Test
	public void testDeleteFriendByUsernames() {
		userDAO.deleteFriendByUsernames("myusername", "tousername");
	}

*/	

}

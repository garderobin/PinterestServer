package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.Board;
import com.bean.Friend;
import com.bean.Request;
import com.bean.User;
import com.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sessionFactory;
	
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public User findUserByUsername(String username){
		
		Session session = sessionFactory.openSession();
		String hql = "from User user where user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			
			
			return  null;
		}
		else {
			return (User)list.get(0);
		}
	}

	@Override
	public void saveUser(User user)
	{
		Session session = sessionFactory.openSession();
		session.save(user);
		session.flush();
		session.close();
	}

	@Override
	public void updateUser(User user)
	{
		Session session = sessionFactory.openSession();
		session.update(user);
		session.flush();
		session.close();
	}
	
	@Override
	public void deleteUser(User user)
	{
		Session session = sessionFactory.openSession();
		session.delete(user);
		session.flush();
		session.close();
	}

	@Override
	public ArrayList<User> findFriendsByUsername(String username) {
		Session session = sessionFactory.openSession();
		String hql = "from User u " +
				"where u.username in (select u1.username from User u1 join u1.friendsForUser1 f1 where f1.user2 = '" + username + "') or " +
				      "u.username in (select u2.username from User u2 join u2.friendsForUser2 f2 where f2.user1 = '" + username + "')";
		
		Query query = session.createQuery(hql);
		ArrayList<User> list = (ArrayList<User>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return  list;
		}
		/*  Another method!!!!
		String hql1 = "select u from User u join u.friendsForUser1 f1 where f1.user2 = '" + username + "'";
		String hql2 = "select u from User u join u.friendsForUser2 f2 where f2.user1 = '" + username + "'";
		Query query1 = session.createQuery(hql1);
		Query query2 = session.createQuery(hql2);
		List<User> list = query1.list();
		List<User> list2 = query2.list();
		session.close();
		list.addAll(list2);
		
		if (list.isEmpty()) {
			return  null;
		}
		else {			
			return  list;
		}
		*/
	}
	
	@Override
	public ArrayList<User> findUserByKeyword(String keyword){
		Session session = sessionFactory.openSession();
		String hql = "from User user where user.username like ?";
		Query query = session.createQuery(hql);
		query.setString(0,"%"+keyword+"%");
		ArrayList<User> list = (ArrayList<User>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	
	@Override
	public void addFriend(Friend friend) {
		Session session = sessionFactory.openSession();
		session.save(friend);
		session.flush();
		session.close();
		
	}

	
	@Override
	public void deleteFriend(Friend friend) {
		String user1 = friend.getUser1().getUsername();
		String user2 = friend.getUser2().getUsername();
		Session session = sessionFactory.openSession();
		String hql = "delete from Friend f where (user1 = '" + user1 + "' and user2 = '" + user2 + 
				"') or (user1 = '" + user2 + "' and user2 = '" + user1 + "')";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.close();		
	}

	@Override
	public Friend findFriendship(String user1, String user2) {
		Session session = sessionFactory.openSession();
		String hql = "from Friend friend where (friend.user1 = '" + user1 + "' and friend.user2 = '" + user2 + "') or (friend.user2 = '" + user1 + "' and friend.user1 = '" + user2 + "')";
		Query query = session.createQuery(hql);
		List<Friend> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Friend) list.get(0);
		}
	}
	
	//test
	
	
	
	
	@Override
	public void deleteFriendByUsernames(String username1, String username2) {
		Session session = sessionFactory.openSession();
		String hql = "delete from Friend f where (user1 = '" + username1 + "' and user2 = '" + username2 + 
				"') or (user1 = '" + username2 + "' and user2 = '" + username1 + "')";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.close();
		
	}

	@Override
	public void deleteFriendByIdFriend(int idfriend) {
		Session session = sessionFactory.openSession();
		String hql = "delete from Friend f where (idfriend = '" + idfriend + "')";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.close();		
	}
	
	@Override
	public Friend findFriendByIdfriend(int idfriend){
		Session session = sessionFactory.openSession();
		String hql = "from Friend f where (f.idfriend = '" + idfriend + "')";
		Query query = session.createQuery(hql);
		List<Friend> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Friend) list.get(0);
		}
	}
	
	@Override
	public int countFriendByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "select count(*) from Friend friend where friend.user1.username = '" + username + "' or friend.user2.username = '" + username + "'";
		//String hql = "select count(*) from User user join user.boards board where user.username = '" + username + "'";
		Query query = session.createQuery(hql);
        //int n = ((Number) query.iterate().next()).intValue();
		int n = ((Number) query.uniqueResult()).intValue();
		session.close();
		return n;
	}
	
	@Override
	public void addRequest(Request request){
		Session session = sessionFactory.openSession();
		session.save(request);
		session.flush();
		session.close();
	}
	
	@Override
	public void deleteRequest(Request request){
		Session session = sessionFactory.openSession();
		session.delete(request);
		session.flush();
		session.close();
	}
	
	@Override
	public void updateRequest(Request request){
		Session session = sessionFactory.openSession();
		session.update(request);
		session.flush();
		session.close();
	}
	
	@Override
	public ArrayList<Request> findRequestByInvitor(String invitor){
		Session session = sessionFactory.openSession();
		String hql = "from Request request where request.invitor.username = '" + invitor + "'";		
		Query query = session.createQuery(hql);
		ArrayList<Request> list = (ArrayList<Request>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return  list;
		}
	}
	
	@Override
	public ArrayList<Request> findRequestByAnsweror(String answeror){
		Session session = sessionFactory.openSession();
		String hql = "from Request request where request.answeror.username = '" + answeror + "'";		
		Query query = session.createQuery(hql);
		ArrayList<Request> list = (ArrayList<Request>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return  list;
		}
	}
	
	@Override
	public int countRequestByAnsweror(String answeror){
		Session session = sessionFactory.openSession();
		String hql = "select count(*) from Request request where request.answeror.username = '" + answeror + "'";
		Query query = session.createQuery(hql);
        int n = ((Number) query.uniqueResult()).intValue();
		session.close();
		return n;
	}
	
	@Override
	public Request findRequestByInvitorAnsweror(String invitor, String answeror){
		Session session = sessionFactory.openSession();
		String hql = "from Request request where request.answeror.username = '" + answeror + "' and request.invitor.username = '" + invitor + "'";		
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return  (Request) list.get(0);
		}
	}
}

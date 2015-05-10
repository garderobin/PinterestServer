package com.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.PinDAO;
import com.bean.*;

public class PinDAOImpl implements PinDAO{

	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addBoard(Board board){
		Session session = sessionFactory.openSession();
		session.save(board);
		session.flush();
		session.close();
	}
	
	@Override
	public void deleteBoard(Board board){
		Session session = sessionFactory.openSession();
		session.delete(board);
		session.flush();
		session.close();
	}
	
	@Override
	public void updateBoard(Board board){
		Session session = sessionFactory.openSession();
		session.update(board);
		session.flush();
		session.close();
	}
	
	@Override
	public Board findBoardByBid(int bid){
		Session session = sessionFactory.openSession();
		String hql = "from Board board where board.bid = '" + bid + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Board)list.get(0);
		}
	}
	
	@Override
	public ArrayList<Board> findBoardByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "from Board board where board.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<Board> list = (ArrayList<Board>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public Board findBoardByUsernameBname(String username, String bname){
		Session session = sessionFactory.openSession();
		String hql = "from Board board where board.user.username = '" + username + "' and board.bname = '" + bname + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Board) list.get(0);
		}
	}
	
	@Override
	public ArrayList<Board> findBoardByFollow(String username){
		Session session = sessionFactory.openSession();
		String hql = "select new Board(board.bid, board.user, board.bname, board.time) from Board board join board.follows follow "
				+ "where (follow.user.username = '" + username + "')";
		Query query = session.createQuery(hql);
		ArrayList<Board> list = (ArrayList<Board>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public ArrayList<Board> findBoardByStream(String stream){
		Session session = sessionFactory.openSession();
		String hql = "select follow.board from Follow follow where follow.stream = '" + stream + "'";
		Query query = session.createQuery(hql);
		ArrayList<Board> list = (ArrayList<Board>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public ArrayList<Board> findBoardByInfo(String info){
		Session session = sessionFactory.openSession();
		String hql = "from Board board where board.info = '" + info + "'";
		Query query = session.createQuery(hql);
		ArrayList<Board> list = (ArrayList<Board>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public ArrayList<Board> findBoardByKeyword(String keyword){
		Session session = sessionFactory.openSession();
		String hql = "from Board board where board.user.username like ? or board.bname like ? " +
				"or board.stream like ?";
		Query query = session.createQuery(hql);
		query.setString(0,"%"+keyword+"%");
		query.setString(1,"%"+keyword+"%");
		query.setString(2,"%"+keyword+"%");
		ArrayList<Board> list = (ArrayList<Board>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public ArrayList<Board> findBoardByPicnum(int picnum){
		Session session = sessionFactory.openSession();
		//String hql = "select new Board(board.bid, board.user.username, board.bname, board.stream, board.time) " +
		//		"from Board board join board.pins pin1 " +
		//		"where pin1.pinid in (select pin2.pinid from Picture picture join picture.pins pin2 where picture.picnum = '" + picnum + "'";
		String hql = "select pin.board from Picture picture join picture.pins pin where picture.picnum = '" + picnum + "'";
		Query query = session.createQuery(hql);
		ArrayList<Board> list = (ArrayList<Board>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public void addPicture(Picture picture){
		Session session = sessionFactory.openSession();
		session.save(picture);
		session.flush();
		session.close();
	}
	
	@Override
	public void deletePicture(Picture picture){
		Session session = sessionFactory.openSession();
		session.delete(picture);
		session.flush();
		session.close();
	}
	
	@Override
	public void updatePicture(Picture picture){
		Session session = sessionFactory.openSession();
		session.update(picture);
		session.flush();
		session.close();
	}
	
	@Override
	public Picture findPictureByPicnum(int picnum){
		Session session = sessionFactory.openSession();
		String hql = "from Picture picture where picture.picnum = '" + picnum + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Picture) list.get(0);
		}
	}
	
	@Override
	public Picture findPictureByPinid(int pinid){
		Session session = sessionFactory.openSession();
		String hql = "select new Picture(picture.picnum, picture.url, picture.sourceUrl) " +
				"from Picture picture join picture.pins pin " +
				"where pin.pinid = '" + pinid + "'";
		Query query = session.createQuery(hql);
		List list =  query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Picture) list.get(0);
		}
	}
	
	@Override
	public ArrayList<Picture> findPictureByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "select new Picture(picture.picnum, picture.url, picture.sourceUrl) " +
				"from Board board join board.pins pin1 , Picture picture join picture.pins pin2 " +
				"where board.user.username = '" + username + "'and pin1.pinid = pin2.pinid";
		Query query = session.createQuery(hql);
		ArrayList<Picture> list = (ArrayList<Picture>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public ArrayList<Picture> findPictureByBid(int bid){
		Session session = sessionFactory.openSession();
		String hql = "select new Picture(picture.picnum, picture.url, picture.sourceUrl) from Picture picture join picture.pins pin" +
				" where pin.board.bid = '" + bid + "'";
		Query query = session.createQuery(hql);
		ArrayList<Picture> list = (ArrayList<Picture>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public ArrayList<Picture> findPictureByLikes(String username){
		Session session = sessionFactory.openSession();
		String hql = "select new Picture(picture.picnum, picture.url, picture.sourceUrl) from Picture picture join picture.likes likes where likes.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<Picture> list = (ArrayList<Picture>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	
	@Override
	public void addPin(Pin pin){
		Session session = sessionFactory.openSession();
		session.save(pin);
		session.flush();
		session.close();
	}
	
	@Override
	public void deletePin(Pin pin){
		Session session = sessionFactory.openSession();
		session.delete(pin);
		session.flush();
		session.close();
	}
	
	@Override
	public void updatePin(Pin pin){
		Session session = sessionFactory.openSession();
		session.update(pin);
		session.flush();
		session.close();
	}
	
	@Override
	public Pin findPinByPinid(int pinid){
		Session session = sessionFactory.openSession();
		String hql = "from Pin pin where pin.pinid = '" + pinid + "'";
		Query query = session.createQuery(hql);
		List<Pin> list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			Pin pin = (Pin) list.get(0);
			return pin;
		}
	}
	
	@Override
	public Pin findPinByBidPicnum(int bid, int picnum){
		Session session = sessionFactory.openSession();
		String hql = "from Pin pin where pin.board.bid = '" + bid + "' and pin.picture.picnum = '" + picnum + "'";
		Query query = session.createQuery(hql);
		List<Pin> list = query.list();
		session.close();
		if(list.isEmpty()){
			return null;
		}
		else{
			return (Pin) list.get(0);
		}
	}
	
	@Override
	public ArrayList<Pin> findPinByBid(int bid){
		Session session = sessionFactory.openSession();
		String hql = "from Pin pin where pin.board.bid = '" + bid + "'";
		Query query = session.createQuery(hql);
		ArrayList<Pin> list = (ArrayList<Pin>) query.list();
		session.close();
		if(list.isEmpty()){
			return null;
		}
		else{
			return list;
		}
	}
	
	@Override
	public ArrayList<Pin> takePin(int pinid){
		Session session = sessionFactory.openSession();
		String hql = "from Pin pin where pin.pinid < '" + pinid + "' order by pin.pinid desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
        query.setMaxResults(30);
		ArrayList<Pin> list = (ArrayList<Pin>) query.list();
		session.close();
		if(list.isEmpty()){
			return null;
		}
		else{
			return list;
		}
	}
	
	@Override
	public void addFollow(Follow follow){
		Session session = sessionFactory.openSession();
		session.save(follow);
		session.flush();
		session.close();
	}
	
	@Override
	public void deleteFollow(Follow follow){
		Session session = sessionFactory.openSession();
		session.delete(follow);
		session.flush();
		session.close();
	}
	
	@Override
	public void updateFollow(Follow follow){
		Session session = sessionFactory.openSession();
		session.update(follow);
		session.flush();
		session.close();
	}
	
	@Override
	public Follow findFollowByIdfollow(int idfollow){
		Session session = sessionFactory.openSession();
		String hql = "from Follow follow where follow.idfollow = '" + idfollow + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.clear();
		if(list.isEmpty())
			return null;
		else
			return (Follow) list.get(0);
	}
	
	@Override
	public Follow findFollowByUsernameBid(String username, int bid){
		Session session = sessionFactory.openSession();
		String hql = "from Follow follow where follow.user.username = '" + username + "' and follow.board.bid = '" + bid + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if(list.isEmpty())
			return null;
		else
			return (Follow) list.get(0);
	}
	
	@Override
	public ArrayList<User> findUserByFollow(int bid){
		Session session = sessionFactory.openSession();
		String hql = "select new User(user.username, user.password, user.email, user.time) " +
				"from User user join user.follows follow where follow.board.bid = '" + bid + "'";
		Query query = session.createQuery(hql);
		ArrayList<User> list = (ArrayList<User>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	
	public ArrayList<Follow> findFollowByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "from Follow follow where follow.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<Follow> list = (ArrayList<Follow>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	
	@Override
	public void addComment(Comment comment){
		Session session = sessionFactory.openSession();
		session.save(comment);
		session.flush();
		session.close();
	}
	
	@Override
	public void deleteComment(Comment comment){
		Session session = sessionFactory.openSession();
		session.delete(comment);
		session.flush();
		session.close();
	}
	
	@Override
	public void updateComment(Comment comment){
		Session session = sessionFactory.openSession();
		session.update(comment);
		session.flush();
		session.close();
	}
	
	@Override
	public Comment findCommentByCid(int cid){
		Session session = sessionFactory.openSession();
		String hql = "from Comment comment where comment.cid = '" + cid + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Comment) list.get(0);
		}
	}
	
	@Override
	public ArrayList<Comment> findCommentByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "from Comment comment where comment.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<Comment> list = (ArrayList<Comment>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public ArrayList<Comment> findCommentByPinid(int pinid){
		Session session = sessionFactory.openSession();
		String hql = "from Comment comment where comment.pin.pinid = '" + pinid + "'";
		Query query = session.createQuery(hql);
		ArrayList<Comment> list = (ArrayList<Comment>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public void addLikes(Likes likes){
		Session session = sessionFactory.openSession();
		session.save(likes);
		session.flush();
		session.close();
	}
	
	@Override
	public void deleteLikes(Likes likes){
		Session session = sessionFactory.openSession();
		session.delete(likes);
		session.flush();
		session.close();
	}
	
	@Override
	public Likes findLikesByIdlikes(int idlikes){
		Session session = sessionFactory.openSession();
		String hql = "from Likes likes where likes.idlikes = '" + idlikes + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Likes) list.get(0);
		}
	}
	
	@Override
	public Likes findLikesByUsernamePicnum(String username, int picnum){
		Session session = sessionFactory.openSession();
		String hql = "from Likes likes where likes.user.username = '" + username + "' and likes.picture.picnum = '" + picnum + "'";
		Query query = session.createQuery(hql);
		List list = query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return (Likes) list.get(0);
		}
	}
	
	@Override
	public ArrayList<Likes> findLikesByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "from User user join user.likes likes where user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<Likes> list = (ArrayList<Likes>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public ArrayList<Likes> findLikesByPicnum(int picnum){
		Session session = sessionFactory.openSession();
		String hql = "from Likes likes where likes.picture.picnum = '" + picnum + "'";
		Query query = session.createQuery(hql);
		ArrayList<Likes> list = (ArrayList<Likes>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
	
	@Override
	public int countBoardByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "select count(*) from Board board where board.user.username = '" + username + "'";
		//String hql = "select count(*) from User user join user.boards board where user.username = '" + username + "'";
		Query query = session.createQuery(hql);
        //int n = ((Number) query.iterate().next()).intValue();
		int n = ((Number) query.uniqueResult()).intValue();
		session.close();
		return n;
	}
	
	@Override
	public int countPinByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "select count(*) from Board board join board.pins pin where board.user.username = '" + username + "'";
		//String hql = "select count(*) from User user join user.boards board where user.username = '" + username + "'";
		Query query = session.createQuery(hql);
        //int n = ((Number) query.iterate().next()).intValue();
		int n = ((Number) query.uniqueResult()).intValue();
		session.close();
		return n;
	}
	
	@Override
	public int countLikesByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "select count(*) from Likes likes where likes.user.username = '" + username + "'";
		//String hql = "select count(*) from User user join user.boards board where user.username = '" + username + "'";
		Query query = session.createQuery(hql);
        //int n = ((Number) query.iterate().next()).intValue();
		int n = ((Number) query.uniqueResult()).intValue();
		session.close();
		return n;
	}
	
	@Override
	public int countPinByBid(int bid){
		Session session = sessionFactory.openSession();
		String hql = "select count(*) from Pin pin where pin.board.bid = '" + bid + "'";
		//String hql = "select count(*) from User user join user.boards board where user.username = '" + username + "'";
		Query query = session.createQuery(hql);
        //int n = ((Number) query.iterate().next()).intValue();
		int n = ((Number) query.uniqueResult()).intValue();
		session.close();
		return n;
	}
	
	@Override
	public int countFollowByBid(int bid){
		Session session = sessionFactory.openSession();
		String hql = "select count(*) from Follow follow where follow.board.bid = '" + bid + "'";
		//String hql = "select count(*) from User user join user.boards board where user.username = '" + username + "'";
		Query query = session.createQuery(hql);
        //int n = ((Number) query.iterate().next()).intValue();
		int n = ((Number) query.uniqueResult()).intValue();
		session.close();
		return n;
	}
	
	@Override
	public int countRepinByPinid(int pinid){
		Session session = sessionFactory.openSession();
		String hql = "select count(*) from Pin pin where pin.repin = '" + pinid + "'";
		//String hql = "select count(*) from User user join user.boards board where user.username = '" + username + "'";
		Query query = session.createQuery(hql);
        //int n = ((Number) query.iterate().next()).intValue();
		int n = ((Number) query.uniqueResult()).intValue();
		session.close();
		return n;
	}
	
	@Override
	public int countLikesByPinid(int pinid){
		Session session = sessionFactory.openSession();
		String hql = "select count(*) " +
				"from Picture picture1 join picture1.likes likes" +
				" where picture1.picnum in (select picture2.picnum from Picture picture2 join picture2.pins pin where pin.pinid = '" + pinid + "')";
		//String hql = "select count(*) from User user join user.boards board where user.username = '" + username + "'";
		Query query = session.createQuery(hql);
        //int n = ((Number) query.iterate().next()).intValue();
		int n = ((Number) query.uniqueResult()).intValue();
		session.close();
		return n;
	}
	
	@Override
	public int countCommentByPinid(int pinid){
		Session session = sessionFactory.openSession();
		String hql = "select count(*) from Pin pin join pin.comments comment where pin.pinid = '" + pinid + "'";
		//String hql = "select count(*) from User user join user.boards board where user.username = '" + username + "'";
		Query query = session.createQuery(hql);
        //int n = ((Number) query.iterate().next()).intValue();
		int n = ((Number) query.uniqueResult()).intValue();
		session.close();
		return n;
	}
	
	@Override
	public int countFollowingByUsername(String username) {
		Session session = sessionFactory.openSession();
		String hql = "select count(*) from Follow follow where follow.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
        int n = ((Number) query.uniqueResult()).intValue();
		session.close();
		return n;
	}
	
	@Override
	public ArrayList<Pin> findPinByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "select new Pin(pin.pinid, pin.board, pin.picture, pin.discription, pin.time, pin.repin) " +
				"from Board board join board.pins pin " +
				"where board.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<Pin> list = (ArrayList<Pin>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}


	@Override
	public ArrayList<String> findStreamByUsername(String username){
		Session session = sessionFactory.openSession();
		String hql = "select distinct follow.stream from Follow follow where follow.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<String> list = (ArrayList<String>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}

	@Override
	public void changeFollowStream(String username, String oldstream, String stream){
		Session session = sessionFactory.openSession();
		String hql = "update Follow follow set follow.stream = '" + stream + "' where follow.stream = '" + oldstream + "' and follow.user.username = '" + username + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.close();
	}
	
	@Override
	public ArrayList<User> findUserByLikes(int picnum){
		Session session = sessionFactory.openSession();
		String hql = "select likes.user from Likes likes where likes.picture.picnum = '" + picnum + "'";
		Query query = session.createQuery(hql);
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
	public ArrayList<Pin> takePinByBidOrder(){
		Session session = sessionFactory.openSession();
		String hql = "from Pin pin order by pin.board.bid";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
        query.setMaxResults(30);
		ArrayList<Pin> list = (ArrayList<Pin>) query.list();
		session.close();
		if(list.isEmpty()){
			return null;
		}
		else{
			return list;
		}
	}

	@Override
	public ArrayList<Pin> findPinByTag(String tag){
		Session session = sessionFactory.openSession();
		String hql = "from Pin pin where pin.note like ?";
		Query query = session.createQuery(hql);
		query.setString(0,"%"+tag+"%");
		ArrayList<Pin> list = (ArrayList<Pin>) query.list();
		session.close();
		if (list.isEmpty()) {
			return  null;
		}
		else {
			return list;
		}
	}
    
}

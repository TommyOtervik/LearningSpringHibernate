package com.tommyotervik.groupfinder.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tommyotervik.groupfinder.demo.entity.Room;
import com.tommyotervik.groupfinder.demo.entity.Student;

@Repository
public class RoomDAOImpl implements RoomDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Room> findAll() {
		
		// get current hibernate session
		
		Session session = entityManager.unwrap(Session.class);
		
		// create a query
		
		
		// OBS from Student, ikke Students, selv om Students er navnet på tabellen i databasen
		
		Query<Room> query = session.createQuery("from Room", Room.class);
		
		
		// execute query and get result list
		
		List<Room> rooms = query.getResultList();
		
		// return the results
		
		return rooms;
	}

	@Override
	public Room findById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Room room = session.get(Room.class, id);
		
		return room;
	}

	@Override
	public void save(Room room) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(room);
		
	}

	@Override
	public void deleteById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("delete from Room where id=:roomId");
		
		query.setParameter("roomId", id);
		
		query.executeUpdate();
		

	}

}

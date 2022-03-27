package com.tommyotervik.groupfinder.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tommyotervik.groupfinder.demo.entity.Group;
import com.tommyotervik.groupfinder.demo.entity.Student;

@Repository
public class GroupDAOImpl implements GroupDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Group> findAll() {
		
		// get current hibernate session
		
		Session session = entityManager.unwrap(Session.class);
		
		// create a query
		
		
		// OBS from Student, ikke Students, selv om Students er navnet på tabellen i databasen
		
		Query<Group> query = session.createQuery("from Group", Group.class);
		
		
		// execute query and get result list
		
		List<Group> groups = query.getResultList();
		
		// return the results
		
		return groups;
	}

	@Override
	public Group findById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Group group = session.get(Group.class, id);
		
		return group;
	}

	@Override
	public void save(Group group) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(group);
		
	}

	@Override
	public void deleteById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("delete from Group where id=:groupId");
		
		query.setParameter("groupId", id);
		
		query.executeUpdate();
		

	}

}

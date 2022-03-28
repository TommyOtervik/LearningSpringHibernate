package com.tommyotervik.groupfinder.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tommyotervik.groupfinder.demo.dao.GroupDAO;
import com.tommyotervik.groupfinder.demo.dao.RoomDAO;
import com.tommyotervik.groupfinder.demo.dao.StudentDAO;
import com.tommyotervik.groupfinder.demo.entity.Group;
import com.tommyotervik.groupfinder.demo.entity.Room;
import com.tommyotervik.groupfinder.demo.entity.Student;

@Service
public class RoomServiceImpl implements RoomService {

	
	@Autowired
	private RoomDAO roomDAO;
	
	@Override
	@Transactional
	public List<Room> findAll() {
		return roomDAO.findAll();
	}

	@Override
	@Transactional
	public Room findById(int id) {
		return roomDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Room room) {
		roomDAO.save(room);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		roomDAO.deleteById(id);

	}

}

package com.tommyotervik.groupfinder.demo.dao;

import java.util.List;

import com.tommyotervik.groupfinder.demo.entity.Group;
import com.tommyotervik.groupfinder.demo.entity.Room;


public interface RoomDAO {

public List<Room> findAll();
	
	public Room findById(int id);
	
	public void save(Room room);
	
	public void deleteById(int id);
}

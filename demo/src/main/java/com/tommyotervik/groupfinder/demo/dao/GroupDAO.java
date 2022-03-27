package com.tommyotervik.groupfinder.demo.dao;

import java.util.List;

import com.tommyotervik.groupfinder.demo.entity.Group;


public interface GroupDAO {

public List<Group> findAll();
	
	public Group findById(int id);
	
	public void save(Group group);
	
	public void deleteById(int id);
}

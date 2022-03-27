package com.tommyotervik.groupfinder.demo.service;

import java.util.List;

import com.tommyotervik.groupfinder.demo.entity.Group;

public interface GroupService {
	
public List<Group> findAll();
	
	public Group findById(int id);
	
	public void save(Group group);
	
	public void deleteById(int id);

}

package com.tommyotervik.groupfinder.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tommyotervik.groupfinder.demo.dao.GroupDAO;
import com.tommyotervik.groupfinder.demo.dao.StudentDAO;
import com.tommyotervik.groupfinder.demo.entity.Group;
import com.tommyotervik.groupfinder.demo.entity.Student;

@Service
public class GroupServiceImpl implements GroupService {

	
	@Autowired
	private GroupDAO groupDAO;
	
	@Override
	@Transactional
	public List<Group> findAll() {
		return groupDAO.findAll();
	}

	@Override
	@Transactional
	public Group findById(int id) {
		return groupDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Group group) {
		groupDAO.save(group);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		groupDAO.deleteById(id);

	}

}

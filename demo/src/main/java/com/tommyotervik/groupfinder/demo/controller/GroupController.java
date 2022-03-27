package com.tommyotervik.groupfinder.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tommyotervik.groupfinder.demo.entity.Group;
import com.tommyotervik.groupfinder.demo.entity.Student;
import com.tommyotervik.groupfinder.demo.exception.GroupNotFoundException;
import com.tommyotervik.groupfinder.demo.exception.StudentNotFoundException;
import com.tommyotervik.groupfinder.demo.service.GroupService;
import com.tommyotervik.groupfinder.demo.service.StudentService;



@RestController
@RequestMapping("/api")
public class GroupController {
	
	// Studentservice dependancy injection
	
	@Autowired
	private GroupService groupService;
	
	@GetMapping("/groups")
	public List<Group> findAll() {
		return groupService.findAll();
	}
	
	@GetMapping("/groups/{groupId}")
	public Group getGroup(@PathVariable int groupId) {
		
		Group group = groupService.findById(groupId);
		
		// TODO Skift til GroupNotFoundException
		if (group == null) {
			throw new GroupNotFoundException("Group not found.");
		}
		
		return group;
	}
	
	@PostMapping("/groups")
	public Group addGroup(@RequestBody Group group) {
		
		// Just in case they pass in ID
		// this is to force a save of a new item, instead of update
		
		group.setId(0);
		
		groupService.save(group);
		
		return group;
	}
	
	@PutMapping("/groups")
	public Group updateGroup(@RequestBody Group group) {
		
		groupService.save(group);
		
		return group;
	}
	
	@DeleteMapping("/groups/{groupId}")
	public String deleteGroup(@PathVariable int groupId) {
		
		Group group = groupService.findById(groupId);
		
		// TODO group exception fiks
		if (group== null) {
			throw new GroupNotFoundException("Group not found.");
		}
		
		groupService.deleteById(groupId);
		
		return "Deleted group id: " + groupId;
	}
	

}

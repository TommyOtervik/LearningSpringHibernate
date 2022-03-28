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
import com.tommyotervik.groupfinder.demo.entity.Room;
import com.tommyotervik.groupfinder.demo.entity.Student;
import com.tommyotervik.groupfinder.demo.exception.GroupNotFoundException;
import com.tommyotervik.groupfinder.demo.exception.StudentNotFoundException;
import com.tommyotervik.groupfinder.demo.service.GroupService;
import com.tommyotervik.groupfinder.demo.service.RoomService;
import com.tommyotervik.groupfinder.demo.service.StudentService;



@RestController
@RequestMapping("/api")
public class RoomController {
	
	// Studentservice dependancy injection
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/rooms")
	public List<Room> findAll() {
		return roomService.findAll();
	}
	
	@GetMapping("/rooms/{roomId}")
	public Room getRoom(@PathVariable int roomId) {
		
		Room room = roomService.findById(roomId);
		
		if (room == null) {
			throw new GroupNotFoundException("Group not found.");
		}
		
		return room;
	}
	
	@PostMapping("/rooms")
	public Room addRoom(@RequestBody Room room) {
		
		// Just in case they pass in ID
		// this is to force a save of a new item, instead of update
		
		room.setId(0);
		
		roomService.save(room);
		
		return room;
	}
	
	@PutMapping("/rooms")
	public Room updateRoom(@RequestBody Room room) {
		
		roomService.save(room);
		
		return room;
	}
	
	@DeleteMapping("/rooms/{roomId}")
	public String deleteRoom(@PathVariable int roomId) {
		
		Room room = roomService.findById(roomId);
		
		if (room == null) {
			throw new GroupNotFoundException("Group not found.");
		}
		
		roomService.deleteById(roomId);
		
		return "Deleted group id: " + roomId;
	}
	
	//@GetMapping("/groups/{groupId}/messages")
	
	

}

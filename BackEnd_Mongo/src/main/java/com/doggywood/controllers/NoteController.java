package com.doggywood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doggywood.entities.Note;
import com.doggywood.services.NoteService;

@CrossOrigin(origins = "*")
@RestController
public class NoteController {

	@Autowired
	NoteService ns;
	
	//works
	@PostMapping(value="/notes", consumes="application/json")
	public Note createNote(@RequestBody Note note) {
		return ns.createNote(note);
	}
	
	// get all
	@GetMapping(value="/notes")
	public List<Note> getAllNotes() {
		return ns.getAllNotes();
	}
	
	//works
	@GetMapping(value="/notes/{id}")
	public Note getNoteById(@PathVariable("id") int id) {
		return ns.getNoteById(id);
	}
	
	@GetMapping(value="/note/appt/{Aid}")
	public Note getNoteByAId(@PathVariable("Aid") int id) {
		return ns.getNoteByAid(id);
	}
	
	@GetMapping(value="/note/pet/{pId}")
	public List<Note> getNoteByPId(@PathVariable("pId")int id) {
		return ns.getNoteByPid(id);
	}
	
	// get notes by appt id
	@GetMapping(value="/appointments/{aid}/notes")
	public List<Note> getNotesByAid(@PathVariable("aid") int aid) {
		return ns.getNotesByAid(aid);
	}
	
	@PutMapping(value="/notes", consumes="application/json")
	public Note updateNote(@RequestBody Note change) {
		return ns.updateNote(change);
	}
	
	//works
	@DeleteMapping(value="/notes/{id}")
	public boolean deleteNote(@PathVariable("id")int id) {
		try {
			ns.deleteNote(ns.getNoteById(id));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

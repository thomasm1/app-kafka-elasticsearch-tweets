package com.doggywood.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doggywood.entities.Note;

@Repository
public interface NoteRepository extends CrudRepository <Note, Integer>{
	
//	@Query("from note n where n.p_id = :pid")
//	List<Note> getNoteByPId(@Param("pid") int pid);

//	@EntityGraph(value = "note.p_id", type = EntityGraphType.FETCH)
//	public List<Note> findAllById(int id);
	
	
	
	Note getNoteByaid(int id);
	
	List<Note> getNoteBypid(int id);
	List<Note> findByAid(int aid);
}

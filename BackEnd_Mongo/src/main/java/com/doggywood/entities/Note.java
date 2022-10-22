package com.doggywood.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class Note {

	@Id
	@GeneratedValue
	@Column(name="n_id")
	private int id;
	

	@Column(name="a_id")
	private int aid;
	

	@Column(name="p_id")
	private int pid;
	
	@Column(name="n_message")
	private String n_message;

	
	
	public Note() {
		super();
	}
	
	@Override
	public String toString() {
		return "Note [n_id=" + id + ", a_id=" + aid + ", p_id=" + pid + ", n_message=" + n_message + "]";
	}
	
	public Note(int a_id, int p_id, String n_message) {
		super();
		this.aid = a_id;
		this.pid = p_id;
		this.n_message = n_message;
	}

	public Note(int n_id, int a_id, int p_id, String n_message) {
		super();
		this.id = n_id;
		this.aid = a_id;
		this.pid = p_id;
		this.n_message = n_message;
	}

	public int getN_id() {
		return id;
	}

	public void setN_id(int n_id) {
		this.id = n_id;
	}

	public int getA_id() {
		return aid;
	}

	public void setA_id(int a_id) {
		this.aid = a_id;
	}

	public int getP_id() {
		return pid;
	}

	public void setP_id(int p_id) {
		this.pid = p_id;
	}

	public String getN_message() {
		return n_message;
	}

	public void setN_message(String n_message) {
		this.n_message = n_message;
	}
	
	
}

package com.sethdeerenproject.taskmanager.taskmanager.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="list")
public class TaskList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="department")
	private String department;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="list_id", referencedColumnName="id")
	private List<Task> tasks = new ArrayList<>();
	
	
	public TaskList(){
		
	}

	public TaskList(String department) {
		this.department = department;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "TodoList [id=" + id + ", department=" + department + ", task=" + tasks + "]";
		
	}

}

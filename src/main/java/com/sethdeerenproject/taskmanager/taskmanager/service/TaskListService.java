package com.sethdeerenproject.taskmanager.taskmanager.service;

import java.util.List;

import com.sethdeerenproject.taskmanager.taskmanager.entity.TaskList;


public interface TaskListService {
	
	public List<TaskList> findAll();
	
	public TaskList findById(int theId);
	
	public void save(TaskList theTodo);
	
	public void deleteById(int theId);

}

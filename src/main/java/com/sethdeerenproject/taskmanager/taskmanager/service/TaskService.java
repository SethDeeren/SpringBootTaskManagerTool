package com.sethdeerenproject.taskmanager.taskmanager.service;

import java.util.List;

import com.sethdeerenproject.taskmanager.taskmanager.entity.Task;

public interface TaskService {
	
	public List<Task> findAll();
	
	public Task findById(int theId);
	
	public void save(Task theTask);
	
	public void deleteById(int theId);
}

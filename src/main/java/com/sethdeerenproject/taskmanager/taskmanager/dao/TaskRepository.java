package com.sethdeerenproject.taskmanager.taskmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sethdeerenproject.taskmanager.taskmanager.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	

}

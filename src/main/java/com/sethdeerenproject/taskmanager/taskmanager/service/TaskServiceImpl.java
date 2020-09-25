package com.sethdeerenproject.taskmanager.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sethdeerenproject.taskmanager.taskmanager.dao.TaskRepository;
import com.sethdeerenproject.taskmanager.taskmanager.entity.Task;

@Service
public class TaskServiceImpl implements TaskService{
	
	private TaskRepository taskRepository;
	
	
	@Autowired
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public List<Task> findAll() {
		
		return taskRepository.findAll();
	}

	@Override
	public Task findById(int theId) {
		
		Optional<Task> theTask = taskRepository.findById(theId);
		
		Task task = theTask.get();
		
		if(task == null) {
			throw new RuntimeException("could not find task with id " + theId);
		}
		
		return task;
	}

	@Override
	public void save(Task theTask) {
		taskRepository.save(theTask);
		
	}

	@Override
	public void deleteById(int theId) {
		
		taskRepository.deleteById(theId);
		
	}

}

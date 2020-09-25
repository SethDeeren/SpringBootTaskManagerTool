package com.sethdeerenproject.taskmanager.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sethdeerenproject.taskmanager.taskmanager.dao.TaskListRepository;
import com.sethdeerenproject.taskmanager.taskmanager.entity.TaskList;

@Service
public class TaskListServiceImpl implements TaskListService{
	
	private TaskListRepository taskListRepository;
	

	@Autowired
	public TaskListServiceImpl(TaskListRepository taskListRepository) {
		this.taskListRepository = taskListRepository;
	}

	@Override
	public List<TaskList> findAll() {
		return taskListRepository.findAll();
	}

	@Override
	public TaskList findById(int theId) {
		Optional<TaskList> theTaskList = taskListRepository.findById(theId);
		
		TaskList taskList = theTaskList.get();
		
		if(taskList == null) {
			throw new RuntimeException("could not find task list with id " + theId);
		}
		
		return taskList;
	}

	@Override
	public void save(TaskList theTaskList) {
		taskListRepository.save(theTaskList);
		
	}

	@Override
	public void deleteById(int theId) {
		taskListRepository.deleteById(theId);
		
	}

}

package com.sethdeerenproject.taskmanager.taskmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sethdeerenproject.taskmanager.taskmanager.entity.TaskList;



public interface TaskListRepository extends JpaRepository<TaskList, Integer> {

}

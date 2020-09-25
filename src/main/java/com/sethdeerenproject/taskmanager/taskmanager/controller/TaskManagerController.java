package com.sethdeerenproject.taskmanager.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sethdeerenproject.taskmanager.taskmanager.entity.Task;
import com.sethdeerenproject.taskmanager.taskmanager.entity.TaskList;
import com.sethdeerenproject.taskmanager.taskmanager.service.TaskListService;
import com.sethdeerenproject.taskmanager.taskmanager.service.TaskService;



@Controller
public class TaskManagerController {
	
	
	private TaskListService taskListService;
	private TaskService taskService;
	
	
	@Autowired
	public TaskManagerController(TaskListService taskListService, TaskService taskService) {
		this.taskListService = taskListService;
		this.taskService = taskService;
	}
	
	
	@GetMapping("/task-list")
	public String taskLists(Model theModel) {
			
		List<TaskList> theTaskLists = taskListService.findAll();
		
		// add to the spring model
		theModel.addAttribute("taskLists", theTaskLists);
		
		return "task-manager";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		TaskList theTaskList = new TaskList();
		
		theModel.addAttribute("taskList", theTaskList);
		
		return "tasklist-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("taskId") int theId, Model theModel) {
		
		TaskList theTaskList = taskListService.findById(theId);
		
		theModel.addAttribute("taskList", theTaskList);
		
		return "tasklist-form";
	}
	
	
	@PostMapping("/save")
	public String saveTaskList(@ModelAttribute("TaskList") TaskList theTaskList) {
		
		// save the employee
		taskListService.save(theTaskList);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/task-list";
	}
	
	
	@GetMapping("/delete")
	public String deleteTaskList(@RequestParam("taskId") int theId) {
		
		try {
			
			
			taskListService.deleteById(theId);
			
			
			
		} catch (Exception e) {
			
			
			
		}
		
		
		
		return "redirect:/task-list";
	}
	
	@GetMapping("/task-list/{taskListId}")
	public String getTaskListViewById(@PathVariable("taskListId") int taskListId, Model theModel) {
		
		TaskList theTaskList = taskListService.findById(taskListId);
		
		theModel.addAttribute("taskList", theTaskList);
		
		
		return "taskList";
	}
	
	@GetMapping("/showFormForAddTask")
	public String showFormForAddTask(@RequestParam("taskListId") int theListId, Model theModel) {
		Task theTask = new Task();
		theTask.setListId(theListId);
		theModel.addAttribute("task", theTask);
		return "task-form";
	}
	
	@GetMapping("/updateTask/{taskId}")
	public String updateTaskById(@PathVariable("taskId") int theTaskId) {
		
		
		Task theTask = taskService.findById(theTaskId);
		
		theTask.setCompleted(!theTask.isCompleted());
		
		taskService.save(theTask);

		
		
		return "redirect:/task-list/" + theTask.getListId();
	}
	
	
	@PostMapping("/save-task")
	public String saveTask(@ModelAttribute("task") Task task) {
		
		
			if(task.getId() != 0) {
				task.setCompleted(!task.isCompleted());
			}
			
			taskService.save(task);
			
	
		
		return "redirect:/task-list/" + task.getListId();
	}
	
	
	@GetMapping("/delete-task/{taskId}")
	public String deleteTask(@PathVariable("taskId") int theTaskId) {
		
		int taskListId = taskService.findById(theTaskId).getListId();
		
		taskService.deleteById(theTaskId);
		
		return "redirect:/task-list/" + taskListId;
	}
	
	
	

}

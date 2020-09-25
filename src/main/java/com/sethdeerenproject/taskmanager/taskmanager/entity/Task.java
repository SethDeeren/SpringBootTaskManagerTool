package com.sethdeerenproject.taskmanager.taskmanager.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="task")
public class Task {

		// define fields
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name="id")
			private int id;
			
			@Column(name="description")
			private String description;
			
			@Column(name="due_date")
			private Date date = new Date();
			
			@Column(nullable = false, columnDefinition = "TINYINT(1)")
			private boolean completed;
			
			@Column(name="list_id")
			private int listId;
			
			public Task() {
				
			}

			public Task( String task) {
				
				this.description = task;
			
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String task) {
				this.description = task;
			}
			
			
		
			public int getListId() {
				return this.listId;
			}

			public void setListId(int todolistId) {
				this.listId = todolistId;
			}

			public boolean isCompleted() {
				return this.completed;
			}

			public void setCompleted(boolean completed) {
				this.completed = completed;
			}
			
			

			public Date getDate() {
				return date;
			}

			public void setDate(Date date) {
				this.date = date;
			}

			@Override
			public String toString() {
				return "Task [id=" + id + ", description=" + description + ", completed=" + completed + ", listId=" + listId
						+ "date=" + date + "]";
			}

}

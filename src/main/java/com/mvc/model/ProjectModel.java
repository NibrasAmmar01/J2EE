package com.mvc.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

//import com.mvc.model.TaskModel;
import com.mvc.entities$.Project;


public class ProjectModel {
	private String code;
	private String description;
	private Date startDate;
	private List<TaskModel> tasks = new ArrayList<>();
	private String errors;
	private String mode = "ajout";
	private Project project;
	
	public ProjectModel() {
	}
	
	public ProjectModel(String code, String description, Date startDate, List<TaskModel> tasks, String errors, String mode) {
		this.code = code;
		this.description = description;
		this.startDate = startDate;
		this.tasks = tasks;
		this.errors = errors;
		this.mode = mode;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public List<TaskModel> getTasks() {
		return tasks;
	}
	public void setTasks(List<TaskModel> tasks) {
		this.tasks = tasks;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public Project getProject() {
	    return project;
	}

	public void setProject(Project project) {
	    this.project = project;
	}
	
}

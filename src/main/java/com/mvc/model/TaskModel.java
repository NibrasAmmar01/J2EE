package com.mvc.model;

import com.mvc.entities$.Task;
import java.util.Date;
import java.util.List;

public class TaskModel {
	private String code;
	private String description;
	private Date startDate;
	private Date endDate;
	private ProjectModel project;
	private String errors;
	private String mode = "ajout";
	private List<Task> tasks;
	public TaskModel() {
	}
	
	public TaskModel(String code, String description, Date startDate, Date endDate, ProjectModel project, String errors, String mode) {
		this.code = code;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.project = project;
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
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public ProjectModel getProject() {
		return project;
	}
	public void setProject(ProjectModel project) {
		this.project = project;
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
	public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}


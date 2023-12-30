package com.mvc.entities$;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.OneToMany;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name = "Project")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	private String code;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@OneToMany(mappedBy = "project")
	private List<Task> tasks;
	
	@Id
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
		this.description  = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public Project() {
		super();
	}
	public Project(String code, String description, Date startDate, List<Task> tasks) {
		super();
		this.code = code;
		this.description = description;
		this.startDate = startDate;
		this.tasks = tasks;
	}
	
	

}

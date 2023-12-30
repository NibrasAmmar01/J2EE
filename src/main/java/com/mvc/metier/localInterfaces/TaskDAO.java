package com.mvc.metier.localInterfaces;

import com.mvc.entities$.*;
import java.util.List;
import java.util.Date;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import jakarta.ejb.Local;

@Local
public interface TaskDAO {
	Task getTaskByCode(String Code);
	List<Task> getAllTasks();
	void addTask(Task task);
	void updateTask(Task task);
	void removeTask(Task task);
	//@Temporal(TemporalType.DATE)
	List<Task> getTaskByPeriod(Date startDate, Date endDate);

}

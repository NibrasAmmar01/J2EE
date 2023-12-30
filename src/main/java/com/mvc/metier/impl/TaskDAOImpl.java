package com.mvc.metier.impl;

import com.mvc.metier.localInterfaces.ProjectDAO;
import com.mvc.metier.localInterfaces.TaskDAO;
import com.mvc.entities$.Project;
import com.mvc.entities$.Task;
import java.util.List;
import java.util.Date;
import jakarta.ejb.Stateless;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Stateless(name = "taskBean")
public class TaskDAOImpl implements TaskDAO {
	@PersistenceContext(unitName = "ProjectUnit")
	EntityManager em;
	
	@Override
	public Task getTaskByCode(String code) {
		return em.find(Task.class, code);
	}
	
	@Override
	public List<Task> getAllTasks() {
	    Query query = em.createQuery("SELECT t FROM Task t");
		return query.getResultList();
		
	}
	
	@Override
	public void addTask(Task task) {
		em.persist(task);
	}
	
	@Override
	public void updateTask(Task task) {
		em.merge(task);
	}
	
	@Override
	public void removeTask(Task task) {
		Task managedTask = em.find(Task.class, task.getCode());
		if (managedTask != null) {
			em.remove(managedTask);
		}
	}
	
	
	public List<Task> getTaskByPeriod(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT t FROM Task t WHERE t.startDate BETWEEN :startDate AND :endDate", Task.class)
				.setParameter("startDate", startDate)
				.setParameter("endDate", endDate)
				.getResultList();
	}
	
	
	
}

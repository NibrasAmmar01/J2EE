package com.mvc.metier.impl;

import com.mvc.metier.localInterfaces.ProjectDAO;
import com.mvc.metier.localInterfaces.TaskDAO;
import com.mvc.entities$.Project;
import com.mvc.entities$.Task;
//import com.mvc.metier.impl.taskDAOImpl;
import java.util.List;
import jakarta.persistence.TypedQuery;
import jakarta.ejb.Stateless;
import jakarta.ejb.EJB;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
//import jakarta.persistence.Query;

@Stateless(name = "projectBean")
public class ProjectDAOImpl implements ProjectDAO {
	@PersistenceContext(unitName = "ProjectUnit")
	EntityManager em;
	
	@EJB
	TaskDAO taskDAO;
	
	@Override
	public Project getProjectByCode(String code) {
		// TODO Auto-generated method stub
		return em.find(Project.class, code);
	}
	
	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		TypedQuery<Project> query = em.createQuery("SELECT p FROM Project p", Project.class);
		return query.getResultList();
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addProject(Project project) {
		// TODO Auto-generated method stub
		em.persist(project);
	}
	
	@Override
	public void updateProject(Project project) {
		// TODO Auto-generated method stub
		em.merge(project);
	}
	
	@Override
	public void removeProject(Project project) {
		// TODO Auto-generated method stub
		Project managedProject = em.find(Project.class, project.getCode());
		if (managedProject != null) {
			em.remove(managedProject);
		}
	}
	
	
	public void addTaskToProject(Task t) {
		// TODO Auto-generated method stub
		if (t.getProject() != null && !t.getProject().equals(this)) {
			t.getProject().getTasks().remove(t);
		}
		taskDAO.addTask(t);;
		em.merge(this);
	}
	
	public void removeTaskFromProject(Task t) {
		// TODO Auto-generated method stub
		Project project = t.getProject();
		if (project != null) {
			taskDAO.removeTask(t);;
			em.merge(project);
		}
		
	}

}

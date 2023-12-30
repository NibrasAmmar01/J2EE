package com.mvc.metier.localInterfaces;

import com.mvc.entities$.*;
import java.util.List;
import jakarta.ejb.Local;

@Local
public interface ProjectDAO {
	void addTaskToProject(Task t);
	void removeTaskFromProject(Task t);
	List<Project> getAllProjects();
	Project getProjectByCode(String Code);
	void addProject(Project project);
	void updateProject(Project project);
	void removeProject(Project project);
	
	
}

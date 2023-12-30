package com.mvc.controllers;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.mvc.entities$.Project;
import com.mvc.metier.localInterfaces.ProjectDAO;
//import com.mvc.metier.impl.ProjectDAOImpl;
import com.mvc.model.ProjectModel;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@EJB
	ProjectDAO projectDAO;
	
	@Override
	public void init() throws ServletException{
	}
	/**
     * @see HttpServlet#HttpServlet()
     */
	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectModel model = new ProjectModel();
		request.setAttribute("model", model);
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("addProject")) {
				try {
				Project project = new Project();
				project.setCode(request.getParameter("code"));
				project.setDescription(request.getParameter("description"));
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date startDate = dateFormat.parse(request.getParameter("startDate"));
					project.setStartDate(startDate);
				} catch(ParseException e) {
					e.printStackTrace();
				}
				model.setMode("addProject");
				
				projectDAO.addProject(project);
				
				request.getRequestDispatcher("/WEB-INF/successInsertProject.jsp").forward(request, response);
				
				} catch(Exception e) {
					e.printStackTrace();
					model.setErrors(e.getMessage());
					request.getRequestDispatcher("/WEB-INF/failedInsertProject.jsp").forward(request, response);
				}
				return;
			} else if (action.equals("removeProject")) {
				String projectCode = request.getParameter("code");
				Project projectToRemove = projectDAO.getProjectByCode(projectCode);
				if (projectToRemove != null) {
					model.setMode("removeProject");
					projectDAO.removeProject(projectToRemove);
					request.getRequestDispatcher("/WEB-INF/successRemoveProject.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/WEB-INF/failedRemoveProject.jsp").forward(request, response);;
				}
				return;
			} else if (action.equals("updateProject")) {
				String projectCode = request.getParameter("code");
				Project existingProject = projectDAO.getProjectByCode(projectCode);
				if (existingProject != null) {
					existingProject.setDescription(request.getParameter("description"));
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					try {
						Date startDate = dateFormat.parse(request.getParameter("startDate"));
						existingProject.setStartDate(startDate);
					} catch(ParseException e) {
						e.printStackTrace();
					}
					model.setMode("updateProject");
					projectDAO.updateProject(existingProject);
					request.getRequestDispatcher("/WEB-INF/successUpdateProject.jsp").forward(request, response);
				} else {
					
					request.getRequestDispatcher("/WEB-INF/failedUpdateProject.jsp").forward(request, response);
				}
				return;
			} else if (action.equals("searchProject")) {
				model.setCode(request.getParameter("code"));
				Project project = projectDAO.getProjectByCode(model.getCode());
				if (project != null) {
					model.setCode(project.getCode());
					model.setDescription(project.getDescription());
					model.setStartDate(project.getStartDate());
					request.getRequestDispatcher("/WEB-INF/listProjects.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/WEB-INF/projectNotFound.jsp").forward(request, response);
				}
				return;
			} else if (action.equals("showProject")) {
				try {
					model.setCode(request.getParameter("code"));
					Project project = projectDAO.getProjectByCode(model.getCode());
					if (project != null) {
						model.setCode(project.getCode());
						model.setDescription(project.getDescription());
						model.setStartDate(project.getStartDate());
						request.getRequestDispatcher("/WEB-INF/project.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("/WEB-INF/projectNotFound.jsp").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
					request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
				}
				return;
			}
			
		}
		request.getRequestDispatcher("/WEB-INF/VueProject.jsp").forward(request, response);
		return;
	}
	

}

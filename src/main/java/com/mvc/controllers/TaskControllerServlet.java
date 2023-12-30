package com.mvc.controllers;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.mvc.entities$.Task;
import com.mvc.metier.localInterfaces.TaskDAO;
import com.mvc.model.TaskModel;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class TaskControllerServlet
 */
@WebServlet("/TaskControllerServlet")
public class TaskControllerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@EJB
	TaskDAO taskDAO;
	
	@Override
	public void init() throws ServletException{
	}
	/**
     * @see HttpServlet#HttpServlet()
     */
	public TaskControllerServlet() {
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
		TaskModel model = new TaskModel();
		request.setAttribute("model", model);
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("addTask")) {
				try {
				model.setCode(request.getParameter("code"));
				model.setDescription(request.getParameter("description"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date startDate = dateFormat.parse(request.getParameter("startDate"));
					model.setStartDate(startDate);
					Date endDate = dateFormat.parse(request.getParameter("endDate"));
					model.setEndDate(endDate);
				} catch(ParseException e) {
					e.printStackTrace();
				}
				Task task = new Task();
				task.setCode(model.getCode());
				task.setDescription(model.getDescription());
				task.setStartDate(model.getStartDate());
				task.setEndDate(model.getEndDate());
				taskDAO.addTask(task);
				request.getRequestDispatcher("/WEB-INF/successInsertTask.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					model.setErrors(e.getMessage());
					request.getRequestDispatcher("/WEB-INF/failedInsertTask.jsp").forward(request, response);
				}
			} else if (action.equals("removeTask")) {
				try {
					String taskCode = request.getParameter("code");
					Task taskToRemove = taskDAO.getTaskByCode(taskCode);
					if (taskToRemove != null ) {
						taskDAO.removeTask(taskToRemove);
						request.getRequestDispatcher("/WEB-INF/successRemoveTask.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("/WEB-INF/failedRemoveTask.jsp").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
					model.setErrors(e.getMessage());
					request.getRequestDispatcher("/WEB-INF/failedRemoveTask.jsp").forward(request, response);
				}
			} else if (action.equals("updateTask")) {
				try {
					String taskCode = request.getParameter("code");
					Task existingTask = taskDAO.getTaskByCode(taskCode);
					if (existingTask != null) {
						existingTask.setDescription(request.getParameter("description"));
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			            try {
			                Date startDate = dateFormat.parse(request.getParameter("startDate"));
			                existingTask.setStartDate(startDate);
			                Date endDate = dateFormat.parse(request.getParameter("endDate"));
			                existingTask.setEndDate(endDate);
			            } catch (ParseException e) {
			                e.printStackTrace();
			            }
			            model.setMode("updateTask");
			            taskDAO.updateTask(existingTask);
			            request.getRequestDispatcher("/WEB-INF/successUpdateTask.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("/WEB-INF/failedUpdateTask.jsp").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
					model.setErrors(e.getMessage());
					request.getRequestDispatcher("/WEB-INF/failedUpdateTask.jsp").forward(request, response);
				}
			}
		}
		request.getRequestDispatcher("/WEB-INF/VueTask.jsp").forward(request, response);
	}

}

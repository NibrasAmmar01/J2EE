<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Project</title>
<link rel="stylesheet" type="text/css" href="css/Styles.css">
</head>
<body>
 <div class="container">
  <h2>Update Project</h2>
  <form action="ControllerServlet" method="post">
   <input type="hidden" name="action" value="updateProject">
   <input type="hidden" name="code" value="${model.code }">
   
   <label for="description">Description:</label>
   <input type="text" name="description" value="${model.description }">
   
   <label for="startDate">Start Date:</label>
   <input type="date" name="startDate" value="${model.startDate }">
   
   <input type="submit" value="Update Project">
  </form>
  <c:if test="${not empty model.errors }">
   <div class="error-message">${model.errors }</div>
  </c:if>
  <c:if test="${model.mode eq 'updateProject' }">
   <div class="success-message">Project updated successfully!</div>
  </c:if>
  
 </div>
</body>
</html>
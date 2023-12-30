<%@page import="com.mvc.entities$.Task"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project Vue</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript">
function confirmer(url){
	var rep = confirm("Are you sure you want to delete?");
	if (rep == true){
		document.location = url;
	}
}
</script>
</head>
<body>
 <div>
  <form action="ControllerServlet" method="post">
   <table>
    <tr>
     <td>Code Project:</td>
     <td><input type="text" name="code"/></td>
     <td><input type="submit" value="searchProject" name="action"/></td>
    </tr>
   </table>
  </form>
 </div>
 <div>
  <form action="ControllerServlet" method="post">
  <input type="hidden" value="${ model.mode }" name="mode"/>
   <table>
    <c:if test="${ model.mode == 'ajout' }">
     <tr>
      <td>Code :</td>
      <td><input type="text" name="code" value="${model.project.code }"/></td>
      <td></td>
     </tr>
    </c:if> 
    <c:if test="${model.mode == 'edit' }">
     <tr>
      <td>Code :</td>
      <td>${model.project.code }<input type="hidden" name="code" value="${model.code }"/></td>
      <td></td>
     </tr>
    </c:if>
    <tr>
     <td>Description :</td>
     <td><input type="text" name="description" value="${model.description }" /></td>
     <td></td>
    </tr>
    <tr>
     <td>Start Date :</td>
     <td><input type="date" name="startDate" value="${model.startDate }" /></td>
     <td></td>
    </tr>
    <tr>
     <td><input type="submit" name="action" value="addProject" /></td>
     <td><input type="submit" name="action" value="removeProject" /></td>
     <td><input type="submit" name="action" value="updateProject" /></td>
     <td><input type="submit" name="action" value="showProject" /></td>
    </tr>
   </table>
  </form>
 </div>
 <div>
  ${model.errors}
 </div>
 <div>
  <table class="Project">
   <tr>
    <th>Code</th> 
    <th>Description</th> 
    <th>Start Date</th>
    <th>Action</th>
   </tr>
   <c:if test="${not empty model.tasks}">
    <tr>
        <td>${model.tasks[0].code}</td>
        <td>${model.tasks[0].description}</td>
        <td>${model.tasks[0].startDate}</td>
        <td>
            <a href="javascript:confirmer('ControllerServlet?action=delete&ref=${model.tasks[0].code}')">Delete</a>
            
            <c:if test="${model.mode eq 'edit'}">
                <a href="ControllerServlet?action=edit&ref=${model.tasks[0].code}">Update</a>
            </c:if>
            
            <c:if test="${not model.mode eq 'edit'}">
                <a href="ControllerServlet?action=edit&ref=${model.tasks[0].code}&mode=edit">Update</a>
            </c:if>

            <a href="javascript:confirm('Are you sure you want to add a task?')">Add Task</a>
            
           
        </td>
    </tr>
   </c:if>
  </table>
 </div>
</body>
</html>
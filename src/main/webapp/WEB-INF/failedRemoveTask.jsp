<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error - Failed to Remove Task</title>
<link rel="stylesheet" type="text/css" href="css/Styles.css">
</head>
<body>
<h2>Failed to Remove Task</h2>
<p>An error occurred while trying to remove the task. Please check the details and try again.</p>
<c:if test="${not empty model.errors }">
 <h3>Error Details: </h3>
 <p>${model.errors }</p>
</c:if>
<a href="/CatalogueMVC/TaskControllerServlet">Go Back Home</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success - Task Inserted</title>
<link rel="stylesheet" type="text/css" href="css/Styles.css">
</head>
<body>
<h2>Task Successfully Inserted</h2>
<p>The Task has been added successfully.</p>

<ul>
 <li><strong>Code:</strong> ${model.code}</li>
 <li><strong>Description:</strong> ${model.description}</li>
 <li><strong>Start Date:</strong> ${model.startDate}</li>
 <li><strong>End Date</strong> ${model.endDate}</li>
</ul>


<a href="/CatalogueMVC/TaskControllerServlet">Go back to home</a>
</body>
</html>
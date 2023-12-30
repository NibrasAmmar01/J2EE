<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success - Project Inserted</title>
<link rel="stylesheet" type="text/css" href="css/Styles.css">
</head>
<body>
<h2>Project Successfully Inserted</h2>
<p>The Project has been added successfully.</p>

<ul>
 <li><strong>Code:</strong> ${model.code}</li>
 <li><strong>Description:</strong> ${model.description}</li>
 <li><strong>Start Date:</strong> ${model.startDate}</li>
</ul>


<a href="/CatalogueMVC/ControllerServlet">Go back to home</a>
</body>
</html>
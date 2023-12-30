<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error - Failed Update Task</title>
<link rel="stylesheet" type="text/css" href="css/Styles.css">

</head>
<body>
 <div class="container">
  <h2>Failed to Update Task</h2>
  <p class="error-message">${sessionScope.updateError}</p>
  <a href="/CatalogueMVC/TaskControllerServlet">Go Back Home</a>
 </div>
</body>
</html>
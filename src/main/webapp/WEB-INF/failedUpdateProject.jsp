<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error - Failed Update Project</title>
<link rel="stylesheet" type="text/css" href="css/Styles.css">

</head>
<body>
 <div class="container">
  <h2>Failed to Update Project</h2>
  <p class="error-message">${sessionScope.updateError}</p>
  <a href="/CatalogueMVC/ControllerServlet">Go Back Home</a>
 </div>
</body>
</html>
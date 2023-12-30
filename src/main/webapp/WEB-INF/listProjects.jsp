<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>List of Projects</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
 <div class="container mt-4">
  <h2>List of Projects</h2>
  <table class="table">
   <thead class="thead-dark">
    <tr>
     <th scope="col">Code</th>
     <th scope="col">Description</th>
     <th scope="col">Start Date</th>
    </tr>
   </thead>
   <tbody>
    <c:forEach items="${model.tasks }" var="p">
     <tr>
      <td>${p.code }</td>
      <td>${p.description }</td>
      <td>${p.startDate}</td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
 </div>
 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
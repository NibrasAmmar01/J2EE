<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Project Details</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
 <div class="container mt-4">
  <h2>Project Details</h2>
  <table class="table">
   <tr>
    <td>Code:</td>
    <td>${model.code }</td>
   </tr>
   <tr>
    <td>Description:</td>
    <td>${model.description }</td>
   </tr>
   <tr>
    <td>Start Date:</td>
    <td>${model.startDate }</td>
   </tr>
  </table>
 </div>
 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>    
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Task Vue</title>
    <!-- Add Bootstrap CSS link -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <script type="text/javascript">
        function confirmer(url) {
            var rep = confirm("Are you sure you want to delete?");
            if (rep == true) {
                document.location = url;
            }
        }
    </script>
</head>
<body>
    <div>
        <form action="TaskControllerServlet" method="post">
            <input type="hidden" value="${ model.mode }" name="mode"/>
            <div class="form-group">
                <label for="code">Code :</label>
                <input type="text" class="form-control" name="code" value="${model.task.code }"/>
            </div>
            <div class="form-group">
                <label for="description">Description :</label>
                <input type="text" class="form-control" name="description" value="${model.description }" />
            </div>
            <div class="form-group">
                <label for="startDate">Start Date :</label>
                <input type="date" class="form-control" name="startDate" value="${model.startDate }" />
            </div>
            <div class="form-group">
                <label for="endDate">End Date :</label>
                <input type="date" class="form-control" name="endDate" value="${model.endDate }" />
            </div>
            <button type="submit" class="btn btn-primary" name="action" value="addTask">Add Task</button>
            <button type="submit" class="btn btn-primary" name="action" value="updateTask">Update Task</button>
            <button type="submit" class="btn btn-primary" name="action" value="removeTask">Remove Task</button>
        </form>
    </div>

    

    <div class="container mt-4">
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>Code</th>
                    <th>Description</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${model.tasks}" var="t">
                    <tr>
                        <td>${t.code}</td>
                        <td>${t.description}</td>
                        <td>${t.startDate}</td>
                        <td>${t.endDate}</td>
                        <td>
                            <a href="javascript:confirmer('TaskControllerServlet?action=delete&ref=${t.code }')" class="btn btn-danger">Delete</a>
                            <c:choose>
                                <c:when test="${model.mode == 'edit' }">
                                    <a href="TaskControllerServlet?action=edit&ref=${t.code }" class="btn btn-warning">Update</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="TaskControllerServlet?action=edit&ref=${t.code}&mode=edit" class="btn btn-warning">Update</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
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

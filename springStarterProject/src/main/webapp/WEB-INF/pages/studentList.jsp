<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Students List</title>
<!-- Bootstrap CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<style type="text/css">
.myrow-container {
	margin: 20px;
}
</style>
</head>
<body class=".container-fluid">
	<div class="container myrow-container">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">
					<div align="left">
						<b>Students List</b>
					</div>
					<div align="right">
						<a href="createStudent">Add New Student</a>
					</div>
				</h3>
			</div>
			<div class="panel-body">
				
				<c:if test="${empty studentList}">
					There are no Students
            	</c:if>
            	<c:if test="${not empty studentList}">
            		<table class="table table-hover table-bordered">
						<thead style="background-color: #bce8f1;">
							<tr>
								<th>Roll Number</th>
								<th>Name</th>
								<th>CPI</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${studentList}" var="emp">
								<tr>
									<td><c:out value="${emp.rollNumber}" /></td>
									<td><c:out value="${emp.name}" /></td>
									<td><c:out value="${emp.cpi}" /></td>
									<td><a href="editStudent?id=${emp.id}">Edit</a></td>
									<td><a href="deleteStudent?id=${emp.id}">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
		<script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
		<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
		<script src="<c:url value="/resources/js/student.js"/>"></script>
</body>
</html>
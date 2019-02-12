<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>
</head>
<body>
	<table class="table">
		<tr>
			<th>Username</th>
			<th>Account No</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Mobile</th>
			<th>Action</th>
		</tr>
		<c:forEach var="user" items="${userList}">
			<c:choose>
				<c:when test="${user.accountNo == updatedUser.accountNo}">
					<form:form name="update" modelAttribute="newAccountHolder"
						action="accountUpdated">
						<tr>
							<td><form:input path="username" value="${user.username}"
									readonly="true" /></td>
							<td><form:input path="accountNo" value="${user.accountNo}"
									readonly="true" /></td>
							<td><form:input path="fname" value="${user.fname}" /></td>
							<td><form:input path="lname" value="${user.lname}" /></td>
							<td><form:input path="mobile" value="${user.mobile}" /></td>
							<td><button type="submit" class="btn btn-primary">
									<i class="fa fa-check" aria-hidden="true"></i>
								</button> <a href="/viewAllAccounts"><i class="fa fa-times"
									aria-hidden="true"></i></a>
							<td><form:input path="role" value="${user.role}"
									readonly="true" hidden="true" /></td>
							<td><form:input path="password" value="${user.password}"
									readonly="true" hidden="true" /></td>
						</tr>
					</form:form>
				</c:when>
				<c:otherwise>
					<tr>
						<td>${user.username}</td>
						<td>${user.accountNo}</td>
						<td>${user.fname}</td>
						<td>${user.lname}</td>
						<td>${user.mobile}</td>
						<td><a href="#"><i class="fa fa-eye" aria-hidden="true"></i></a>
							<a href="/updateAccount?accountNo=${user.accountNo}"><i
								class="fa fa-pencil" aria-hidden="true"></i></a> <a
							href="/deleteAccount?accountNo=${user.accountNo}"><i
								class="fa fa-trash" aria-hidden="true"></i></a></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
</body>
</html>
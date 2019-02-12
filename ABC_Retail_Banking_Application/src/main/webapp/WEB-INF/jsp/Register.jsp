<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>

<!-- Bootstrap files -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<!-- Bootstrap script files -->
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
	<div class="card col-lg-4">
		<div class="card-header">Register</div>
		<div class="card-body">
			<form:form modelAttribute="newAccountHolder" action="/registeration">
				<div class="form-group">
					<label>First Name</label>
					<form:input type="text" class="form-control" id="fname"
						path="fname" placeholder="Enter First Name" />
					<form:errors path="fname">
						<font style="color: red;">Please enter First Name</font>
					</form:errors>
				</div>
				<div class="form-group">
					<label>Last Name</label>
					<form:input type="text" class="form-control" id="lname"
						path="lname" placeholder="Enter Last Name" />
					<form:errors path="lname">
						<font style="color: red;">Please enter Last Name</font>
					</form:errors>
				</div>
				<div class="form-group">
					<label>Account Holder Name</label>
					<form:input type="text" class="form-control" id="username"
						path="username" placeholder="Account Holder Name" />
					<form:errors path="username">
						<font style="color: red;">Please enter Account name(Username)</font>
					</form:errors>
				</div>
				<div class="form-group">
					<label>Password</label>
					<form:input type="password" class="form-control" id="password"
						path="password" placeholder="Password" />
					<form:errors path="password">
						<font style="color: red;">Please enter Password</font>
					</form:errors>
				</div>
				<div class="form-group">
					<label>Mobile</label>
					<form:input type="number" class="form-control" id="mobile"
						path="mobile" placeholder="Enter Mobile Number" />
					<form:errors path="mobile">
						<font style="color: red;">Please enter Mobile number</font>
					</form:errors>
				</div>
				<div class="form-group">
					<label for="inputState">Role</label>
					<form:select id="role" path="role" class="form-control">
						<option selected disabled="disabled">Choose...
						<option value="admin">Admin</option>
						<option value="user">User</option>
					</form:select>
					<form:errors path="role">
						<font style="color: red;">Please select Role</font>
					</form:errors>
				</div>
				<button type="submit" class="btn btn-primary">Register</button>
			</form:form>
		</div>
	</div>
</body>
</html>
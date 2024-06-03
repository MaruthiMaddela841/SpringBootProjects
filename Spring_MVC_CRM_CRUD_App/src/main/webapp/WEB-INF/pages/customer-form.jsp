<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Form</title>
<style>
table {
	width: 50%;
	margin: 20px auto;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	text-align: left;
	border: 1px solid #ddd;
}

th {
	background-color: #f4f4f4;
}

input[type="text"], input[type="number"] {
	width: 100%;
	padding: 8px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	border: none;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<center>
		<div id="wrapper">
			<div id="header">
				<h2>CRM-Customer Relationship Manager</h2>
			</div>
		</div>
		<div id="container">
			<h3>Save Customer </h3>
			<div id="content">
				<form:form action="saveCustomer" method="post" modelAttribute="customer">
				<form:hidden path="id"/>
					<table>
						<tr>
							<th>Customer First Name</th>
							<td><form:input path="firstName" required="true" /></td>
						</tr>
						<tr>
							<th>Customer Last Name</th>
							<td><form:input path="lastName" required="true" /></td>
						</tr>
						<tr>
							<th>Customer Email</th>
							<td><form:input path="email" required="true" /></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: center;"><input
								type="submit" value="Submit"></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
		<div style='clear;both;'>
		<p>
		<a href='${pageContext.request.contextPath}/customer/list'>Back to List</a>
		</p>
		</div>
	</center>
</body>
</html>
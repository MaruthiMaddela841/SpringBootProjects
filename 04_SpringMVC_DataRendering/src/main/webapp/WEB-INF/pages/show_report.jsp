<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
	<center>
		<h1 style='color: red; text-align: center'>Displaying List of DTO
			Objects</h1>
		<table border='1'>
			<tr>
				<th>ENO</th>
				<th>ENAME</th>
				<th>EDESG</th>
				<th>SALARY</th>
			</tr>
			<c:forEach var="employee" items="${employees}">
			<tr>
			<td>${employee.eno}</td>
			<td>${employee.ename}</td>
			<td>${employee.edesg}</td>
			<td>${employee.salary}</td>
			</tr>
		</c:forEach>
		</table>
		<hr>
		<h1 style='color: red; text-align: center'>Displaying Simple
			Values</h1>
		<h1>Name is::${name}</h1>
		<h1>Age is::${age}</h1>
		<h1>Address is::${address}</h1>
		<hr>
		<h1 style='color: red; text-align: center'>Displaying Array
			Values</h1>
		<c:forEach var="country" items="${countries}">
			<h1>${country}</h1>
		</c:forEach>
		<hr>
		<h1 style='color: red; text-align: center'>Displaying List Values</h1>
		<c:forEach var="subject" items="${subjectsList}">
			<h1>${subject}</h1>
		</c:forEach>
		<hr>
		<h1 style='color: red; text-align: center'>Displaying Set Values</h1>
		<c:forEach var="mobile" items="${mobileNumbers}">
			<h1>${mobile}</h1>
		</c:forEach>
		<hr>
		<h1 style='color: red; text-align: center'>Displaying Map Values</h1>
		<c:forEach var="detail" items="${details}">
			<h1>${detail.key}==========>${detail.value}</h1>
		</c:forEach>
	</center>
</body>
</html>
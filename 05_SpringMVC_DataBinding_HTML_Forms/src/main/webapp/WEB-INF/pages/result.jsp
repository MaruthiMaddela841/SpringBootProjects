<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result Page</title>
</head>
<body>
	<table border='1'>
			<tr>
				<th>ENO</th>
				<th>ENAME</th>
				<th>EDESG</th>
				<th>SALARY</th>
			</tr>
			<tr>
			<td>${employee.eno}</td>
			<td>${employee.ename}</td>
			<td>${employee.edesg}</td>
			<td>${employee.salary}</td>
			</tr>
		</table>
</body>
</html>
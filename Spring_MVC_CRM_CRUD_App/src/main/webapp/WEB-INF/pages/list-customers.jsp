<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Customers</title>
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
/*         th { */
/*             background-color: #add8e6; */
/*         } */
/*         tr{ */
/*         	background-color: #ffcccb; */
/*         } */
th {
	background-color: #2c3e50; /* Dark Blue */
	color: #ffffff; /* White */
}

tr:nth-child(even) {
	background-color: #ecf0f1; /* Light Gray */
}

tr:nth-child(odd) {
	background-color: #ffffff; /* White */
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
/* New Button Styles */
.add-customer-btn {
	background-color: #3498db; /* Blue */
	color: #ffffff; /* White */
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	margin-bottom: 20px; /* Add some space between button and table */
}

.add-customer-btn:hover {
	background-color: #2980b9; /* Darker Blue on Hover */
}
/* Style for action buttons */
.action-buttons {
	display: flex;
	justify-content: space-around;
}

.edit-btn, .delete-btn {
	background-color: #f39c12; /* Orange */
	color: #ffffff; /* White */
	border: none;
	padding: 8px 15px;
	border-radius: 5px;
	cursor: pointer;
}

.edit-btn:hover, .delete-btn:hover {
	background-color: #e67e22; /* Darker Orange on Hover */
}
</style>
<script>
	function redirectToForm() {
		window.location.href = 'showForm';
		return false;
	}
	function confirmDelete() {
        return confirm("Are you sure you want to delete this customer?");
    }
</script>
</head>
<body>
	<center>
		<div id="wrapper">
			<div id="header">
				<h2>CRM-Customer Relationship Manager</h2>
			</div>
		</div>
		<div id="container">
			<div id="content">
				<!-- New Button -->
				<input type="button" class="add-customer-btn" value="Add Customer"
					onclick="redirectToForm()">
				<table>
					<tr>
						<th style='text-align: center'>ID</th>
						<th style='text-align: center'>First Name</th>
						<th style='text-align: center'>Last Name</th>
						<th style='text-align: center'>Email</th>
						<th style='text-align: center'>Action</th>
					</tr>
					<c:forEach var="customer" items="${customers}">
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
						<c:url var="deleteLink" value="/customer/showFormForDelete">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
						<tr>
							<td>${customer.id}</td>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<td class="action-buttons">
								<!-- Action buttons column --> 
								<a href="${updateLink}" class="edit-btn">Update</a>
								<a href="${deleteLink}" class="delete-btn" onclick="return confirmDelete()">Delete</a>

							</td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>
	</center>
</body>
</html>
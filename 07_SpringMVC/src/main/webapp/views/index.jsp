<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Store</title>
</head>
<body>
	<h1>Welcome to my book store....</h1>
	<form action="save" method="post">
		<table>
			<tr>
				<td>Book Name:</td>
				<td><input type="text" name="bname"></td>
			</tr>
			<tr>
				<td>Author Name:</td>
				<td><input type="text" name="authorName"></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>